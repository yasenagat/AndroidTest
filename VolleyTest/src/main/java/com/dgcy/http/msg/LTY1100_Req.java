package com.dgcy.http.msg;

import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;
import com.google.gson.annotations.Expose;

public class LTY1100_Req extends AbstractRequestMsg<LTY1100_Res> {

    public LTY1100_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private LTY1100_Req_Body req_Body = new LTY1100_Req_Body();

    public void setReq_Body(LTY1100_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class LTY1100_Req_Body implements IRequestBody {

        public LTY1100_Req_Body() {
        }

        public LTY1100_Req_Body(String lotteryId, String chartType) {
            this.lotteryId = lotteryId;
            this.chartType = chartType;
        }

        @Expose
        private String lotteryId = "";

        @Expose
        private String chartType = "";

        public String getLotteryId() {
            return lotteryId;
        }

        public void setLotteryId(String lotteryId) {
            this.lotteryId = lotteryId;
        }

        public String getChartType() {
            return chartType;
        }

        public void setChartType(String chartType) {
            this.chartType = chartType;
        }
    }

    @Override
    public Class<LTY1100_Res> getResponseType() {
        return LTY1100_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_1;
    }

    @Override
    protected boolean needSign() {
        return false;
    }

}
