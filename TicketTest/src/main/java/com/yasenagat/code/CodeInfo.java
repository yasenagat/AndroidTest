package com.yasenagat.code;

/**
 * Created by zf on 2015/6/11.
 */
public class CodeInfo {
    private static final long serialVersionUID = 1L;

    private String code = "";

    private String saleId = "";

    private String src = "0";

    private String note = "";

    public CodeInfo() {
    }

    public CodeInfo(String code, String saleId, String note) {
        this.code = code;
        this.saleId = saleId;
        this.note = note;
    }

    //                public CodeInfo(String code, String saleId) {
//                    super();
//                    this.code = code;
//                    this.saleId = saleId;
//                }



    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", saleId:'" + saleId + '\'' +
                ", src:'" + src + '\'' +
                ", note:'" + note + '\'' +
                '}';
    }
}
