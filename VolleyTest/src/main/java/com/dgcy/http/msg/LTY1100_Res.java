package com.dgcy.http.msg;

import com.dgcy.http.base.AbstractResponseBody;
import com.dgcy.http.base.AbstractResponseMsg;
import com.google.gson.annotations.Expose;

public class LTY1100_Res extends AbstractResponseMsg<LTY1100_Res.LTY1100_Res_Body> {

    public static class LTY1100_Res_Body extends AbstractResponseBody {

        @Expose
        private String lastIssue = ""; // 截至期次
        @Expose
        private String miss_sep = ""; // 遗漏标红
        @Expose
        private String miss; //遗漏列表

        public LTY1100_Res_Body() {
        }

        public LTY1100_Res_Body(String lastIssue, String miss_sep, String miss) {
            this.lastIssue = lastIssue;
            this.miss_sep = miss_sep;
            this.miss = miss;
        }

        public String getLastIssue() {
            return lastIssue;
        }

        public void setLastIssue(String lastIssue) {
            this.lastIssue = lastIssue;
        }

        public String getMiss_sep() {
            return miss_sep;
        }

        public void setMiss_sep(String miss_sep) {
            this.miss_sep = miss_sep;
        }

        public String getMiss() {
            return miss;
        }

        public void setMiss(String miss) {
            this.miss = miss;
        }

        @Override
        public String toString() {
            return "LTY1100_Res_Body{" +
                    "lastIssue='" + lastIssue + '\'' +
                    ", miss_sep='" + miss_sep + '\'' +
                    ", miss='" + miss + '\'' +
                    '}';
        }
    }

    @Override
    protected Class<LTY1100_Res_Body> getResBodyType() {
        return LTY1100_Res_Body.class;
    }

}
