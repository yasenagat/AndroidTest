package com.dgcy.http.msg;


import com.google.gson.annotations.Expose;
import com.dgcy.http.base.AbstractResponseBody;
import com.dgcy.http.base.AbstractResponseMsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class INF1000_Res extends AbstractResponseMsg<INF1000_Res.INF1000_Res_Body> {

    public static class INF1000_Res_Body extends AbstractResponseBody {

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
            private String sn = ""; // 序号
            @Expose
            private String id = ""; // 编号
            @Expose
            private String title = ""; // 标题
            @Expose
            private String from = ""; // 来源
            @Expose
            private String editor = ""; // 作者
            @Expose
            private String time = ""; // 时间
            @Expose
            private String type = ""; // 类型
            @Expose
            private String name = ""; // 类别名称
            @Expose
            private String intro = ""; // 简介
            @Expose
            private String hot = ""; // 是否热门
            @Expose
            private String top = ""; // 是否置顶
            @Expose
            private String url = "";
            @Expose
            private String relateType = "";
            @Expose
            private String relateContent = "";

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFrom() {
                return from;
            }

            public void setFrom(String from) {
                this.from = from;
            }

            public String getEditor() {
                return editor;
            }

            public void setEditor(String editor) {
                this.editor = editor;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getHot() {
                return hot;
            }

            public void setHot(String hot) {
                this.hot = hot;
            }

            public String getTop() {
                return top;
            }

            public void setTop(String top) {
                this.top = top;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getRelateType() {
                return relateType;
            }

            public void setRelateType(String relateType) {
                this.relateType = relateType;
            }

            public String getRelateContent() {
                return relateContent;
            }

            public void setRelateContent(String relateContent) {
                this.relateContent = relateContent;
            }

        }

    }

    @Override
    protected Class<INF1000_Res_Body> getResBodyType() {
        return INF1000_Res_Body.class;
    }

}
