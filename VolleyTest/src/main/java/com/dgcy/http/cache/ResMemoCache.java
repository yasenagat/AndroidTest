package com.dgcy.http.cache;


import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.util.HttpLog;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by zf on 2015/3/24.
 */
public enum ResMemoCache implements IMemoCache<IRequestMsg, String> {

    INSTANCE;

    private static ConcurrentMap<String, ICacheEntity<String>> cacheData = new ConcurrentHashMap<String, ICacheEntity<String>>();


    @Override
    public String get(IRequestMsg iRequestMsg) throws Exception {

        ICacheEntity<String> iCacheEntity = cacheData.get(iRequestMsg.getUniquenKey());

        HttpLog.debug("Get iCacheEntity (key : " + iRequestMsg.getUniquenKey() + " ) From MemoCache : " + iCacheEntity);


        if (iCacheEntity != null) {

            HttpLog.debug("Check iCacheEntity => iCacheEntity.getExpireTime() : "
                    + iCacheEntity.getExpireTime()
                    + " # System.currentTimeMillis() : " + System.currentTimeMillis());

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

        HttpLog.debug("Put iCacheEntity Into MemoCache (key : " + iRequestMsg.getUniquenKey() + " )");
        cacheData.put(iRequestMsg.getUniquenKey(), ResCacheEntity.create(value, System.currentTimeMillis() + CacheCfg.getExpireTime(iRequestMsg.getCmd())));
    }

    @Override
    public void remove(IRequestMsg iRequestMsg) throws Exception {
        cacheData.remove(iRequestMsg.getUniquenKey());
    }
}
