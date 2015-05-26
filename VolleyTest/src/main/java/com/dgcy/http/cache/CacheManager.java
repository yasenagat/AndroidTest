package com.dgcy.http.cache;



import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.util.HttpLog;

import java.io.File;

/**
 * Created by zf on 2015/3/24.
 */
public enum CacheManager {
    INSTANCE;

    IFileCache<IRequestMsg, String> iFileCache;
    IMemoCache<IRequestMsg, String> iMemoCache;

    public String get(IRequestMsg requestMsg) {

        String responseData = null;

        try {
            if (requestMsg != null) {
                responseData = iMemoCache.get(requestMsg);

                HttpLog.debug("Get ResponseData From MemoCache : " + responseData);
                if (responseData == null) {
                    responseData = iFileCache.get(requestMsg);
                    HttpLog.debug("Get ResponseData From FileCache : " + responseData);
                    if (responseData != null) {
                        iMemoCache.put(requestMsg, responseData);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public boolean isCache(IRequestMsg requestMsg) {

        return requestMsg == null ? false : CacheCfg.isCache(requestMsg.getCmd());
    }

    public void put(IRequestMsg requestMsg, String responseData) {

//        HttpLog.debug("requestMsg : " + requestMsg);
//        HttpLog.debug("responseData : " + responseData);
        if (null != requestMsg && null != responseData && !"".equals(responseData)) {
            try {
                iMemoCache.put(requestMsg, responseData);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    iFileCache.put(requestMsg, responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void init(String _cacheDir) {
        iFileCache = ResFileCache.INSTANCE;
        iMemoCache = ResMemoCache.INSTANCE;
        CacheUtil.init(_cacheDir);
        clear();
    }

    private void clear() {

        HttpLog.debug("start clear res cache");
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File(CacheUtil.cacheDir);
                for (File f : file.listFiles()) {

                    try {
                        HttpLog.debug("f.getName() : " + f.getName());

                        if(f.isFile()){
                            Object object = CacheUtil.getAsObject(f.getName());

                            if (null != object) {

                                if (object instanceof ICacheEntity) {
                                    ICacheEntity<String> iCacheEntity = (ICacheEntity<String>) object;
                                    if (iCacheEntity.getExpireTime() + CacheCfg.delTime < System.currentTimeMillis()) {
                                        f.delete();
                                    }
                                } else {
                                    f.delete();
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        f.delete();
                    }
                }
            }
        }).start();

    }
}
