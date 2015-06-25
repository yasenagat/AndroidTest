package com.yasenagat.chartview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public interface IChartDraw {

    public void draw(Canvas canvas, int nowX, int nowY, int viewWidth, int viewHeight, float scale);

    public boolean getCanScale();

    public boolean[] getCanScroll();

    public float[] getScaleRange();

    public int[] getScrollRange();

    public void initChart(Context context, int viewWidth, int viewHeight, float scale);

    public boolean initOk();

    public boolean onClick(MotionEvent motionEvent, float nowX, float nowY, int viewWidth, int viewHeight, float scale);

    public boolean onLongClick(MotionEvent motionEvent, float nowX, float nowY, int viewWidth, int viewHeight, float scale);

    public void reCalcScroll(float scale, int viewWidth, int viewHeight);
}