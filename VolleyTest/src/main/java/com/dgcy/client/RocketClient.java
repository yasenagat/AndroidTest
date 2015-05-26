package com.dgcy.client;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.base.IResponseListener;
import com.dgcy.http.cache.CacheManager;
import com.dgcy.http.util.HttpLog;
import com.dgcy.volley.RocketRequest;
import com.dgcy.volley.RocketRequestCache;

/**
 * Created by zf on 2015/5/11.
 */
public class RocketClient implements IHttpClient {

    private static final String TAG = RocketClient.class.getName();
    private static transient boolean init = false;
    private static Context sContext;
    private static RequestQueue mRequestQueue;

    @Override
    public void init(Context context) {
        if (!init) {
            sContext = context;
            mRequestQueue = Volley.newRequestQueue(sContext);
            init = true;
        }
    }


    @Override
    public <T> void asyncRequest(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener) throws Exception {

        asyncRequest(requestMsg, responseListener, TAG);
    }

    @Override
    public <T> void asyncRequest(final IRequestMsg<T> requestMsg, final IResponseListener<T> responseListener, Object tag) throws Exception {


        if (CacheManager.INSTANCE.isCache(requestMsg)) {

            final String responseData = CacheManager.INSTANCE.get(requestMsg);
            HttpLog.warn(TAG, "Get Response From Cache : " + responseData);
            if (responseData == null || "".equals(responseData)) {
                asyncOnNetWorkCache(requestMsg, responseListener, tag);
            } else {
                responseListener.onSuccess(responseListener.getResponse(responseData, requestMsg.getResponseType()));
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        responseListener.onSuccess(responseListener.getResponse(responseData, requestMsg.getResponseType()));
//                    }
//                });
            }
        } else {
            asyncOnNetWork(requestMsg, responseListener, tag);
        }


    }

    private <T> void asyncOnNetWork(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener, Object tag) {
        mRequestQueue.add(new RocketRequest<T>(requestMsg, responseListener, tag));
    }

    private <T> void asyncOnNetWorkCache(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener, Object tag) {
        mRequestQueue.add(new RocketRequestCache<T>(requestMsg, responseListener, tag));
    }

    @Override
    public <T> void before(IRequestMsg<T> requestMsg) throws Exception {
        HttpLog.debug(TAG, "before");
    }

    @Override
    public <T> void after(IRequestMsg<T> requestMsg) throws Exception {
        HttpLog.debug(TAG, "after");
    }

    @Override
    public boolean initSuccess() {
        return init;
    }

    @Override
    public void cancelAll(RequestQueue.RequestFilter filter) {

        mRequestQueue.cancelAll(filter);
    }

    @Override
    public void cancelAll(Object tag) {
        HttpLog.warn(TAG, "cancelAll");
        mRequestQueue.cancelAll(tag);
    }

    @Override
    public void stop() {
        mRequestQueue.stop();
    }
}
