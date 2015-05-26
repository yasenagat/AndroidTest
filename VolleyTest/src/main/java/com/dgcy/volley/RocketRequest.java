package com.dgcy.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractResponseMsg;
import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.base.IResponseListener;
import com.dgcy.http.cache.CacheManager;
import com.dgcy.http.util.HttpLog;

import java.io.UnsupportedEncodingException;


/**
 * Created by zf on 2015/5/11.
 */
public class RocketRequest<T> extends Request<String> {
    private static final String TAG = RocketRequest.class.getName();
    protected IResponseListener<T> mIResponseListener;
    public IRequestMsg<T> mIRequestMsg;

//    public RocketRequest(IRequestMsg<T> mRequestMsg, IResponseListener<T> mIResponseListener,
//                         Response.ErrorListener errorListener) {
//        super(Method.POST, createUrl(mRequestMsg), errorListener);
//        this.mIRequestMsg = mRequestMsg;
//        this.mIResponseListener = mIResponseListener;
//    }
//
//    public RocketRequest(IRequestMsg<T> mRequestMsg, final IResponseListener<T> mIResponseListener) {
//        super(Method.POST, createUrl(mRequestMsg), new DefautlErrorListener(mIResponseListener));
//        this.mIRequestMsg = mRequestMsg;
//        this.mIResponseListener = mIResponseListener;
//    }

    public RocketRequest(IRequestMsg<T> mRequestMsg, final IResponseListener<T> mIResponseListener, Object tag) {
        super(Method.POST, createUrl(mRequestMsg), new DefautlErrorListener(mIResponseListener));
        this.mIRequestMsg = mRequestMsg;
        this.mIResponseListener = mIResponseListener;
        this.setTag(tag);
    }


    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(String response) {
        HttpLog.warn(TAG, "Get Response From Server : " + response);

        T t = mIResponseListener.getResponse(response, mIRequestMsg.getResponseType());

        if (bizSuccess(t)) {
            mIResponseListener.onSuccess(t);
        } else {
            mIResponseListener.onBizFailure(t);
        }

    }

    protected boolean bizSuccess(T t) {

        if (t != null && t instanceof AbstractResponseMsg) {
            AbstractResponseMsg res = (AbstractResponseMsg<T>) t;
            if (IConsParams.RESULTCODE_SUCCESS.equals(res.getResult())) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        return mIRequestMsg.getRequestData().getBytes();
    }

    private static <T> String createUrl(IRequestMsg<T> requestMsg) {
        return IConsParams.URL + IConsParams.SLASH + IConsParams.productId + IConsParams.SLASH + IConsParams.channelId + IConsParams.SLASH
                + requestMsg.getCmd();
    }

}
