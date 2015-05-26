package com.dgcy.http.base;

public interface IRequestMsg<T> {

    String getCmd();

    String getRequestData();

    Class<T> getResponseType();

    String getUniquenKey();

    long getExpireTime();

    String getCacheKey();
}
