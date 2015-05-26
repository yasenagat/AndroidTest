package com.dgcy.http.msg;



import com.google.gson.annotations.Expose;
import com.dgcy.http.base.AbstractResponseBody;
import com.dgcy.http.base.AbstractResponseMsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class INF1001_Res extends AbstractResponseMsg<INF1001_Res.INF1001_Res_Body> {

    public static class INF1001_Res_Body extends AbstractResponseBody {

        @Expose
        private List<InfoItem> items = new ArrayList<InfoItem>();

        public List<InfoItem> getItems() {
            return items;
        }

        public void setItems(List<InfoItem> items) {
            this.items = items;
        }

        public static class InfoItem implements Serializable {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            @Expose
            public String lotteryId = ""; // 玩法编号
            @Expose
            public String lotteryName = ""; // 玩法名称
            @Expose
            public String title = ""; // 标题
            @Expose
            public String time = ""; // 时间
            @Expose
            public String intro = ""; // 简介
            @Expose
            public String from = ""; // 简介

            public String getLotteryId() {
                return lotteryId;
            }

            public void setLotteryId(String lotteryId) {
                this.lotteryId = lotteryId;
            }

            public String getLotteryName() {
                return lotteryName;
            }

            public void setLotteryName(String lotteryName) {
                this.lotteryName = lotteryName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

        }

    }

    @Override
    protected Class<INF1001_Res_Body> getResBodyType() {
        return INF1001_Res_Body.class;
    }

}
