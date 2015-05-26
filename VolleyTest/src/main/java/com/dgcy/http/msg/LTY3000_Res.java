package com.dgcy.http.msg;

import com.dgcy.http.base.AbstractResponseBody;
import com.dgcy.http.base.AbstractResponseMsg;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LTY3000_Res extends AbstractResponseMsg<LTY3000_Res.LTY3000_Res_Body> {

    public static class LTY3000_Res_Body extends AbstractResponseBody implements
            Serializable {

        private static final long serialVersionUID = 1L;

        @Expose
        private List<OrderInfo> items = new ArrayList<OrderInfo>();

        public static class OrderInfo {
            @Expose
            private String sn = "";
            @Expose
            private String orderType = "";
            @Expose
            private String orderId = "";
            @Expose
            private String isPresent = "";
            @Expose
            private String lotteryId = "";
            @Expose
            private String lotteryName = "";
            @Expose
            private String orderTypeDesc = "";
            @Expose
            private String subTypeName = "";
            @Expose
            private String orderTime = "";
            @Expose
            private String orderMoney = "";
            @Expose
            private String guaranteeMoney = "";
            @Expose
            private String issue = "";
            @Expose
            private String issueCount = "";
            @Expose
            private String issueLeft = "";
            @Expose
            private String status = "";
            @Expose
            private String statusDesc = "";
            @Expose
            private String prize = "";

            private String day;
            private String moneth;
            private boolean isShow;
            private boolean isInit;

            private boolean check;

            private int flag = 3;//

            public int getFlag() {
                return flag;
            }

            public void setFlag(int flag) {
                this.flag = flag;
            }

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public boolean isInit() {
                return isInit;
            }

            public void setInit(boolean isInit) {
                this.isInit = isInit;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public String getMoneth() {
                return moneth;
            }

            public void setMoneth(String moneth) {
                this.moneth = moneth;
            }

            public boolean isShow() {
                return isShow;
            }

            public void setShow(boolean isShow) {
                this.isShow = isShow;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getOrderType() {
                return orderType;
            }

            public void setOrderType(String orderType) {
                this.orderType = orderType;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
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

            public String getOrderTypeDesc() {
                return orderTypeDesc;
            }

            public void setOrderTypeDesc(String orderTypeDesc) {
                this.orderTypeDesc = orderTypeDesc;
            }

            public String getSubTypeName() {
                return subTypeName;
            }

            public void setSubTypeName(String subTypeName) {
                this.subTypeName = subTypeName;
            }

            public String getOrderTime() {
                return orderTime;
            }

            public void setOrderTime(String orderTime) {
                this.orderTime = orderTime;
            }

            public String getOrderMoney() {
                return orderMoney;
            }

            public void setOrderMoney(String orderMoney) {
                this.orderMoney = orderMoney;
            }

            public String getGuaranteeMoney() {
                return guaranteeMoney;
            }

            public void setGuaranteeMoney(String guaranteeMoney) {
                this.guaranteeMoney = guaranteeMoney;
            }

            public String getIssue() {
                return issue;
            }

            public void setIssue(String issue) {
                this.issue = issue;
            }

            public String getIssueCount() {
                return issueCount;
            }

            public void setIssueCount(String issueCount) {
                this.issueCount = issueCount;
            }

            public String getIssueLeft() {
                return issueLeft;
            }

            public void setIssueLeft(String issueLeft) {
                this.issueLeft = issueLeft;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatusDesc() {
                return statusDesc;
            }

            public void setStatusDesc(String statusDesc) {
                this.statusDesc = statusDesc;
            }

            public String getPrize() {
                return prize;
            }

            public void setPrize(String prize) {
                this.prize = prize;
            }

            public String getIsPresent() {
                return isPresent;
            }

            public void setIsPresent(String isPresent) {
                this.isPresent = isPresent;
            }

            @Override
            public String toString() {
                return "OrderInfo{" +
                        "check=" + check +
                        '}';
            }
        }

        public List<OrderInfo> getItems() {
            return items;
        }

        public void setItems(List<OrderInfo> items) {
            this.items = items;
        }

    }

    @Override
    protected Class<LTY3000_Res_Body> getResBodyType() {
        return LTY3000_Res_Body.class;
    }

}
