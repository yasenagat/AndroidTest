package com.dgcy.http.msg;

import com.google.gson.annotations.Expose;
import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;

public class LTY1000_Req extends AbstractRequestMsg<LTY1000_Res> {

    public LTY1000_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private LTY1000_Req_Body req_Body = new LTY1000_Req_Body();

    public void setReq_Body(LTY1000_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class LTY1000_Req_Body implements IRequestBody {

        public LTY1000_Req_Body() {
        }


        public LTY1000_Req_Body(String lotteryIds) {
            super();
            this.lotteryIds = lotteryIds;
        }


        @Expose
        private String lotteryIds = "";


        public String getLotteryIds() {
            return lotteryIds;
        }


        public void setLotteryIds(String lotteryIds) {
            this.lotteryIds = lotteryIds;
        }


    }

    @Override
    public Class<LTY1000_Res> getResponseType() {
        return LTY1000_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_2;
    }

    @Override
    protected boolean needSign() {
        return false;
    }

}
