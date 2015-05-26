package com.dgcy.http.msg;


import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;

public class INF1001_Req extends AbstractRequestMsg<INF1001_Res> {

    @Override
    protected boolean needSign() {
        return false;
    }

    public INF1001_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private INF1001_Req_Body req_Body = new INF1001_Req_Body();

    public void setReq_Body(INF1001_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class INF1001_Req_Body implements IRequestBody {

        public INF1001_Req_Body() {
        }

        @Override
        public String toString() {
            return this.getClass().getName();
        }
    }

    @Override
    public Class<INF1001_Res> getResponseType() {
        return INF1001_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_1;
    }

}
