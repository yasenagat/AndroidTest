package com.dgcy.http.base;

import com.google.gson.annotations.Expose;

public abstract class AbstractResponseBody implements IResponseBody {
    @Expose
    private String result;
    @Expose
    private String resultDesc;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
