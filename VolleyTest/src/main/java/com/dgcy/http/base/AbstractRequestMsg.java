package com.dgcy.http.base;


import com.google.gson.annotations.Expose;
import com.dgcy.client.IConsParams;
import com.dgcy.http.util.HttpLog;
import com.dgcy.http.util.JsonUtil;
import com.dgcy.http.util.MessageCodeHelper;
import com.dgcy.http.util.StringTools;

public abstract class AbstractRequestMsg<T> implements IRequestMsg<T> {

    private static final String TAG = AbstractRequestMsg.class.toString();

    @Override
    public String getCmd() {
        return this.getClass().getSimpleName()
                .substring(0, this.getClass().getSimpleName().lastIndexOf("_"));
    }

    @Override
    public String getRequestData() {
        /** check **/
        keyId = "".equals(keyId) ? IConsParams.keyId : keyId;
        sid = "".equals(sid) ? IConsParams.sId : sid;
        HttpLog.debug(TAG, "keyId : " + keyId);
        HttpLog.debug(TAG, "sid : " + sid);
        /** check **/
        this.body = encodeBody(getRequestBody());
        HttpLog.debug(TAG, "req_mi_body :" + this.body);
        this.digest = createDigest();
        if (needSign())
            this.sign = createSign();

        return JsonUtil.toJson(this);
    }

    @Expose
    private String cmd = getCmd();
    @Expose
    private String keyId = IConsParams.keyId;
    @Expose
    private String sid = IConsParams.sId;
    @Expose
    private String sign = "";
    @Expose
    public String mode = makeSure() == null ? IConsParams.DATA_MODULE_1
            : makeSure();

    @Expose
    private String body = "";

    @Expose
    private String digest = "";

    @Expose
    private String deviceId = IConsParams.deviceId;

    @Expose
    private String productId = IConsParams.productId;

    @Expose
    private String productVersion = IConsParams.productVersion;

    @Expose
    private String channelId = IConsParams.channelId;

    protected abstract IRequestBody getRequestBody();

    private String encodeBody(IRequestBody requestBody) {
        try {
            HttpLog.debug(TAG,
                    "req_ming_body : " + JsonUtil.toJson(requestBody));
            return MessageCodeHelper.EncodeBody(this.mode,
                    JsonUtil.toJson(requestBody), IConsParams.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String createDigest() {
        return StringTools.MD5EncodeToHex(this.body);
    }

    public String getKeyId() {
        return "".equals(keyId) ? IConsParams.keyId : keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getSid() {
        return "".equals(sid) ? IConsParams.sId : sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    protected abstract String makeSure();

    protected abstract boolean needSign();

    private String createSign() {
        HttpLog.debug(TAG,
                getCmd() + " : " + sid + " : " + IConsParams.sKey + " : "
                        + digest);
        return StringTools.MD5EncodeToHex(getCmd() + sid + IConsParams.sKey
                + digest);
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUniquenKey() {

//        HttpLog.debug("getCmd() : " + getCmd());
//        HttpLog.debug("getRequestBody() : " + getRequestBody());
        return StringTools.MD5EncodeToHex(getCmd() + getRequestBody());
    }

    public long getExpireTime() {
        return System.currentTimeMillis() + 1000 * 60;
    }

    @Override
    public String getCacheKey() {
        return getUniquenKey();
    }
}
