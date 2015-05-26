package com.dgcy.http.base;

import android.widget.Toast;

import com.dgcy.client.IConsParams;
import com.dgcy.http.util.HttpLog;
import com.dgcy.http.util.JsonUtil;

/**
 * Created by zf on 2015/5/11.
 */
public abstract class DefaultJsonResponseListener<T> implements IResponseListener<T> {

    private static final String TAG = DefaultJsonResponseListener.class.getName();

    @Override
    public T getResponse(String responseData, Class<T> clazz) {
        return parseResponse(responseData, clazz);
    }

    private <T> T parseResponse(String responseData, Class<T> clazz) {
        return JsonUtil.jsonToClass(responseData, clazz);
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onBizFailure(T t) {
        if (t != null && t instanceof AbstractResponseMsg) {
            AbstractResponseMsg res = (AbstractResponseMsg<T>) t;
            if (IConsParams.RESULTCODE_SUCCESS.equals(res.getResult())) {
                //do nothing
            } else {
                HttpLog.warn(TAG, "Biz Error Code : " + res.getResult());
            }
        }
    }

    @Override
    public void onExecuteFailure() {

    }
}
