package com.dgcy.http.cache;

/**
 * Created by zf on 2015/3/24.
 */
public class ResCacheEntity implements ICacheEntity<String> {

    private String responseData;
    private long addTime = System.currentTimeMillis();
    private long expireTime;

    public ResCacheEntity(String responseData, long expireTime) {
        this.responseData = responseData;
        this.expireTime = expireTime;
    }

    @Override
    public String getValue() {
        return responseData;
    }

    @Override
    public long getAddTime() {
        return addTime;
    }

    @Override
    public long getExpireTime() {
        return expireTime;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public static ICacheEntity create(String responseData, long expireTime) {
        return new ResCacheEntity(responseData, expireTime);
    }
}
