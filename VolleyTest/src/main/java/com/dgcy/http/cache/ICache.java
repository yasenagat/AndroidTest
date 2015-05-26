package com.dgcy.http.cache;

/**
 * Created by zf on 2015/3/24.
 */
public interface ICache<K, V> {

    public V get(K k) throws Exception;

    public void put(K k, V v) throws Exception;

    public void remove(K k) throws Exception;
}
