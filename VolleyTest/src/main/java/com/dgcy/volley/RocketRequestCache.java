package com.dgcy.volley;

import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.base.IResponseListener;
import com.dgcy.http.cache.CacheManager;

/**
 * Created by zf on 2015/5/11.
 */
public class RocketRequestCache<T> extends RocketRequest<T> {

    public RocketRequestCache(IRequestMsg<T> mRequestMsg, final IResponseListener<T> mIResponseListener, Object tag) {
        super(mRequestMsg, mIResponseListener, tag);
    }

    @Override
    protected void deliverResponse(String response) {

        T t = mIResponseListener.getResponse(response, mIRequestMsg.getResponseType());

        if (bizSuccess(t)) {
            mIResponseListener.onSuccess(t);
            CacheManager.INSTANCE.put(this.mIRequestMsg, response);
        } else {
            mIResponseListener.onBizFailure(t);
        }
    }
}
