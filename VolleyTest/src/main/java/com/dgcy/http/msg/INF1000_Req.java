package com.dgcy.http.msg;


import com.google.gson.annotations.Expose;
import com.dgcy.client.IConsParams;
import com.dgcy.http.base.AbstractRequestMsg;
import com.dgcy.http.base.IRequestBody;

public class INF1000_Req extends AbstractRequestMsg<INF1000_Res> {

    @Override
    protected boolean needSign() {
        return false;
    }

    public INF1000_Req() {

    }

    @Override
    protected IRequestBody getRequestBody() {
        return req_Body;
    }

    private INF1000_Req_Body req_Body = new INF1000_Req_Body();

    public void setReq_Body(INF1000_Req_Body req_Body) {
        this.req_Body = req_Body;
    }

    public static class INF1000_Req_Body implements IRequestBody {

        public INF1000_Req_Body() {
        }

        public INF1000_Req_Body(String startSn, QueryFilter filter) {
            super();
            this.startSn = startSn;
            this.filter = filter;
        }

        @Expose
        private String startSn = "";
        @Expose
        private QueryFilter filter = new QueryFilter();

        public String getStartSn() {
            return startSn;
        }

        public void setStartSn(String startSn) {
            this.startSn = startSn;
        }

        public QueryFilter getFilter() {
            return filter;
        }

        public void setFilter(QueryFilter filter) {
            this.filter = filter;
        }

        public static class QueryFilter {

            public QueryFilter() {
                super();
            }

            public QueryFilter(String group, String lotteryId) {
                super();
                this.group = group;
                this.lotteryId = lotteryId;
            }

            @Expose
            private String group = "";
            @Expose
            private String lotteryId = "";

            public String getGroup() {
                return group;
            }

            public void setGroup(String group) {
                this.group = group;
            }

            public String getLotteryId() {
                return lotteryId;
            }

            public void setLotteryId(String lotteryId) {
                this.lotteryId = lotteryId;
            }

            @Override
            public String toString() {
                return "QueryFilter{" +
                        "group='" + group + '\'' +
                        ", lotteryId='" + lotteryId + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "INF1000_Req_Body{" +
                    "startSn='" + startSn + '\'' +
                    ", filter=" + filter +
                    '}';
        }
    }

    @Override
    public Class<INF1000_Res> getResponseType() {
        return INF1000_Res.class;
    }

    @Override
    protected String makeSure() {
        return IConsParams.DATA_MODULE_1;
    }

}
