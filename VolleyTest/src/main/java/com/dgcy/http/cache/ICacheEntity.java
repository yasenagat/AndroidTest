package com.dgcy.http.cache;

import java.io.Serializable;

/**
 * Created by zf on 2015/3/24.
 */
public interface ICacheEntity<T> extends Serializable {

    public T getValue();

    public long getAddTime();

    public long getExpireTime();
}
