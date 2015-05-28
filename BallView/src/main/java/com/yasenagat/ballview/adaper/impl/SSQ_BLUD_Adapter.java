package com.yasenagat.ballview.adaper.impl;

import android.content.Context;

import com.yasenagat.ballview.R;
import com.yasenagat.ballview.adaper.DefaultAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/5/25.
 */
public class SSQ_BLUD_Adapter extends DefaultAdapter {

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

    }

    public SSQ_BLUD_Adapter(Context context) {
        super(context);
        this.textList = ssq_text_list;
        initDefautlState();
    }

    @Override
    protected int getStyleByState(int state) {
        int style = R.style.State_No_Pick_Blue;
        if (state == STATE_NO_PICK) {
            style = R.style.State_No_Pick_Blue;
        } else if (state == STATE_PICK) {
            style = R.style.State_Pick_Blue;
        } else if (state == STATE_DAN) {
            style = R.style.State_Dan_Blue;
        } else if (state == STATE_BAN) {
            style = R.style.State_Ban_Blue;
        }
        return style;
    }

    @Override
    protected int getBackGroundResourceByState(int state) {
        int bg_resource_id = R.drawable.ball_blue_n;
        if (state == STATE_NO_PICK) {
            bg_resource_id = R.drawable.ball_blue_n;
        } else if (state == STATE_PICK) {
            bg_resource_id = R.drawable.ball_blue;
        } else if (state == STATE_DAN) {
            bg_resource_id = R.drawable.ball_blue;
        } else if (state == STATE_BAN) {
            bg_resource_id = R.drawable.ball_blue_ban_p;
        }
        return bg_resource_id;
    }
}
