package com.dgcy.http.base;


import com.dgcy.client.IConsParams;
import com.google.gson.annotations.Expose;
import com.dgcy.http.util.HttpLog;
import com.dgcy.http.util.JsonUtil;
import com.dgcy.http.util.MessageCodeHelper;
import com.dgcy.http.util.StringTools;

public abstract class AbstractResponseMsg<T> implements IResponseMsg {

    private static final String TAG = AbstractResponseMsg.class.toString();

    @Expose
    private String result;
    @Expose
    private String mode;
    @Expose
    private String body;
    @Expose
    private String digest;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    @Override
    public String toString() {
        return "responseData => result = " + this.result + " ; mode = "
                + this.mode + " ; digest = " + this.digest + " ; body = "
                + this.body;
    }

    public boolean checkDigest() {
        String digest = StringTools.MD5EncodeToHex(this.getBody());
        if (digest.equals(this.getDigest())) {
            return true;
        } else {
            HttpLog.debug(TAG, digest + " != " + this.getDigest());
            return false;
        }
    }

    public String decodeBody() {
        try {
            return MessageCodeHelper.DecodeBody(this.getMode(), this.getBody(),
                    IConsParams.key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private T t;

    public T getRes_Body() {
        if (t != null) {
            return t;
        }
        t = JsonUtil.jsonToClass(decodeBody(), getResBodyType());
        return t;
    }


    protected abstract Class<T> getResBodyType();


}
