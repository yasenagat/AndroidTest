package com.dgcy.http.base;

/**
 * Created by zf on 2015/5/11.
 */
public interface IResponseListener<T> {

//    void onSuccess(String responseData, Class<T> clazz);

    void onSuccess(T t);

    T getResponse(String responseData, Class<T> clazz);

    void onBizFailure(T t);

    void onExecuteFailure();

    void onFinish();
}
