package com.dgcy.http.msg;


import com.google.gson.annotations.Expose;
import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;

public class INF1002_Req extends AbstractRequestMsg<INF1002_Res> {

    @Override
    protected boolean needSign() {
        return false;
    }

    public INF1002_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private INF1002_Req_Body req_Body = new INF1002_Req_Body();

    public void setReq_Body(INF1002_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class INF1002_Req_Body implements IRequestBody {

        public INF1002_Req_Body() {
        }

        public INF1002_Req_Body(String id) {
            super();
            this.id = id;
        }

        @Expose
        private String id = "";

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    @Override
    public Class<INF1002_Res> getResponseType() {
        return INF1002_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_1;
    }

}
