package com.y.adapter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/5/23.
 */
public class SSQ_RED_Adapter extends DefaultAdapter {

    private static List<String> ssq_text_list = new ArrayList<String>();

    static {
        ssq_text_list.add("01");
        ssq_text_list.add("02");
        ssq_text_list.add("03");
        ssq_text_list.add("04");
        ssq_text_list.add("05");
        ssq_text_list.add("06");
        ssq_text_list.add("07");
        ssq_text_list.add("08");
        ssq_text_list.add("09");
        ssq_text_list.add("10");
        ssq_text_list.add("11");
        ssq_text_list.add("12");
        ssq_text_list.add("13");
        ssq_text_list.add("14");
        ssq_text_list.add("15");
        ssq_text_list.add("16");
        ssq_text_list.add("17");
        ssq_text_list.add("18");
        ssq_text_list.add("19");
        ssq_text_list.add("20");
        ssq_text_list.add("21");
        ssq_text_list.add("22");
        ssq_text_list.add("23");
        ssq_text_list.add("24");
        ssq_text_list.add("25");
        ssq_text_list.add("26");
        ssq_text_list.add("27");
        ssq_text_list.add("28");
        ssq_text_list.add("29");
        ssq_text_list.add("30");
        ssq_text_list.add("31");
        ssq_text_list.add("32");
        ssq_text_list.add("33");
    }

    public SSQ_RED_Adapter(Context context) {
        super(context);
        this.textList = ssq_text_list;
        initDefautlState();
    }

}
