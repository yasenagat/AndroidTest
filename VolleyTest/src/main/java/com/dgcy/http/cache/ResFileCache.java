package com.dgcy.http.cache;


import com.dgcy.http.base.IRequestMsg;

import java.io.File;

/**
 * Created by zf on 2015/3/24.
 */
public enum ResFileCache implements IFileCache<IRequestMsg, String> {

    INSTANCE;

    @Override
    public String get(IRequestMsg iRequestMsg) throws Exception {

        Object object = CacheUtil.getAsObject(iRequestMsg.getUniquenKey());

        if (null != object) {

            ICacheEntity<String> iCacheEntity = (ICacheEntity<String>) object;
            if (iCacheEntity.getExpireTime() < System.currentTimeMillis()) {
                remove(iRequestMsg);
                return null;
            } else {
                return iCacheEntity.getValue();
            }

        }

        return null;
    }

    @Override
    public void put(IRequestMsg iRequestMsg, String value) throws Exception {

        CacheUtil.put_(iRequestMsg.getUniquenKey(), ResCacheEntity.create(value, System.currentTimeMillis() + CacheCfg.getExpireTime(iRequestMsg.getCmd())));

    }

    @Override
    public void remove(IRequestMsg iRequestMsg) throws Exception {

        File file = CacheUtil.newFile(iRequestMsg.getUniquenKey());
        file.delete();
    }
}
