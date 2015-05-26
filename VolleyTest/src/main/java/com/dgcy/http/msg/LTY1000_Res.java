package com.dgcy.http.msg;


import com.google.gson.annotations.Expose;
import com.dgcy.http.base.AbstractResponseBody;
import com.dgcy.http.base.AbstractResponseMsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LTY1000_Res extends AbstractResponseMsg<LTY1000_Res.LTY1000_Res_Body> {

    public static class LTY1000_Res_Body extends AbstractResponseBody {

        @Expose
        private List<IssueItem> items = new ArrayList<IssueItem>();

        public List<IssueItem> getItems() {
            return items;
        }

        public void setItems(ArrayList<IssueItem> items) {
            this.items = items;
        }

        public static class IssueItem implements Serializable {

            public IssueItem() {

            }

            /**
             *
             */
            private static final long serialVersionUID = 1L;
            @Expose
            private String lotteryId = ""; // 玩法编号
            @Expose
            private String lotteryName = ""; // 玩法名称
            @Expose
            private String issue = ""; // 期号
            @Expose
            private String leftSellTime = ""; // 剩余销售时间
            @Expose
            private String icon = ""; // 图标
            @Expose
            private String lotterySell = ""; // 本玩法是否销售
            @Expose
            private String isToday = ""; // 是否今日开奖
            @Expose
            private String isUnion = ""; // 是否可以合买
            @Expose
            private String upIssue = ""; // 上一期期号
            @Expose
            private String remainTotal = ""; // 奖池留存
            @Expose
            private String desc = ""; // 玩法描述
            @Expose
            private String descColor = ""; // 描述字色 FFFFFF
            @Expose
            private String timesCount = "1000"; // 最大倍数
            @Expose
            private String betCount = ""; // 最大组数
            @Expose
            private String issueCount = ""; // 允许号码最大期数

            @Expose
            private String status = ""; // 销售状态：1预售，2销售

            private long firstLoadTime;
            private String firstLoadLeftSellTime = "";


            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public long getFirstLoadTime() {
                return firstLoadTime;
            }

            public void setFirstLoadTime(long firstLoadTime) {
                this.firstLoadTime = firstLoadTime;
            }

            public String getFirstLoadLeftSellTime() {
                return firstLoadLeftSellTime;
            }

            public void setFirstLoadLeftSellTime(String firstLoadLeftSellTime) {
                this.firstLoadLeftSellTime = firstLoadLeftSellTime;
            }

            public String getIsUnion() {
                return isUnion;
            }

            public void setIsUnion(String isUnion) {
                this.isUnion = isUnion;
            }

            public String getDescColor() {
                return descColor;
            }

            public void setDescColor(String descColor) {
                this.descColor = descColor;
            }

            public String getIssueCount() {
                return issueCount;
            }

            public void setIssueCount(String issueCount) {
                this.issueCount = issueCount;
            }

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

            public String getIssue() {
                return issue;
            }

            public void setIssue(String issue) {
                this.issue = issue;
            }

            public String getLeftSellTime() {
                return leftSellTime;
            }

            public void setLeftSellTime(String leftSellTime) {
                this.leftSellTime = leftSellTime;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getLotterySell() {
                return lotterySell;
            }

            public void setLotterySell(String lotterySell) {
                this.lotterySell = lotterySell;
            }

            public String getIsToday() {
                return isToday;
            }

            public void setIsToday(String isToday) {
                this.isToday = isToday;
            }

            public String getUpIssue() {
                return upIssue;
            }

            public void setUpIssue(String upIssue) {
                this.upIssue = upIssue;
            }

            public String getRemainTotal() {
                return remainTotal;
            }

            public void setRemainTotal(String remainTotal) {
                this.remainTotal = remainTotal;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getTimesCount() {
                return timesCount;
            }

            public void setTimesCount(String timesCount) {
                this.timesCount = timesCount;
            }

            public String getBetCount() {
                return betCount;
            }

            public void setBetCount(String betCount) {
                this.betCount = betCount;
            }

            @Override
            public String toString() {
                return "IssueItem{" +
                        "lotteryId='" + lotteryId + '\'' +
                        ", lotteryName='" + lotteryName + '\'' +
                        ", issue='" + issue + '\'' +
                        ", leftSellTime='" + leftSellTime + '\'' +
                        ", icon='" + icon + '\'' +
                        ", lotterySell='" + lotterySell + '\'' +
                        ", isToday='" + isToday + '\'' +
                        ", isUnion='" + isUnion + '\'' +
                        ", upIssue='" + upIssue + '\'' +
                        ", remainTotal='" + remainTotal + '\'' +
                        ", desc='" + desc + '\'' +
                        ", descColor='" + descColor + '\'' +
                        ", timesCount='" + timesCount + '\'' +
                        ", betCount='" + betCount + '\'' +
                        ", issueCount='" + issueCount + '\'' +
                        ", status='" + status + '\'' +
                        ", firstLoadTime=" + firstLoadTime +
                        ", firstLoadLeftSellTime='" + firstLoadLeftSellTime + '\'' +
                        '}';
            }
        }

    }

    @Override
    protected Class<LTY1000_Res_Body> getResBodyType() {
        return LTY1000_Res_Body.class;
    }

}
