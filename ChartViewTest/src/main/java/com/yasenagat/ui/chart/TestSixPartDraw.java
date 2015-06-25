package com.yasenagat.ui.chart;

import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by zf on 2015/6/2.
 */


public class TestSixPartDraw extends AbstractSixPartDraw {

    @Override
    public void drawLeftTop() {
        Canvas canvas = this.mPictureLeftTop.beginRecording(200, 200);
        mPaint.setColor(0xFFDC6161);
        mPaint.setTextSize(50f);
        canvas.drawText("123", 50, 50, mPaint);
        canvas.drawColor(Color.WHITE);
        this.mPictureLeftTop.endRecording();
    }

    @Override
    public void drawLeftCenter() {

    }

    @Override
    public void drawLeftBottom() {

    }

    @Override
    public void drawCenterTop() {

    }

    @Override
    public void drawCenter() {

    }

    @Override
    public void drawCenterBottom() {

    }
}
