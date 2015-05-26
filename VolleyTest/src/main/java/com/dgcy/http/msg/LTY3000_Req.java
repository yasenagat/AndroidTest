package com.dgcy.http.msg;

import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;
import com.google.gson.annotations.Expose;

public class LTY3000_Req extends AbstractRequestMsg<LTY3000_Res> {

    public LTY3000_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private LTY3000_Req_Body req_Body = new LTY3000_Req_Body();

    public void setReq_Body(LTY3000_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class LTY3000_Req_Body implements IRequestBody {

        public LTY3000_Req_Body() {
        }

        public LTY3000_Req_Body(String startSn, INF1000_Req.INF1000_Req_Body.QueryFilter filter) {
            super();
            this.startSn = startSn;
            this.filter = filter;
        }

        @Expose
        private String startSn = "";
        @Expose
        private INF1000_Req.INF1000_Req_Body.QueryFilter filter;

        public String getStartSn() {
            return startSn;
        }

        public void setStartSn(String startSn) {
            this.startSn = startSn;
        }

        public INF1000_Req.INF1000_Req_Body.QueryFilter getFilter() {
            return filter;
        }

        public void setFilter(INF1000_Req.INF1000_Req_Body.QueryFilter filter) {
            this.filter = filter;
        }

        @Override
        public String toString() {
            return "LTY3000_Req_Body{" +
                    "startSn='" + startSn + '\'' +
                    ", filter=" + filter +
                    '}';
        }
    }

    @Override
    public Class<LTY3000_Res> getResponseType() {
        return LTY3000_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_2;
    }

    @Override
    protected boolean needSign() {
        return true;
    }

}
