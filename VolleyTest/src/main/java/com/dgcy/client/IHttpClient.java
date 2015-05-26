package com.dgcy.client;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.base.IResponseListener;

/**
 * Created by zf on 2015/5/11.
 */
public interface IHttpClient {

    public void init(Context sContext);

    public <T> void asyncRequest(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener) throws Exception;

    public <T> void asyncRequest(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener, Object tag) throws Exception;

    public <T> void before(IRequestMsg<T> requestMsg) throws Exception;

    public <T> void after(IRequestMsg<T> requestMsg) throws Exception;

    public boolean initSuccess();

    public void cancelAll(RequestQueue.RequestFilter filter);

    public void cancelAll(final Object tag);

    public void stop();
}
