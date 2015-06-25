package com.yasenagat.chartview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

public class ChartView extends View
        implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnTouchListener {
    private IChartDraw mChart;
    private GestureDetector mGestureDetector;
    private float mLastDistance = 0.0F;
    private float mNowX = 0.0F;
    private float mNowY = 0.0F;
    private float mScale = 1.0F;
    private Scroller mScroller;
    private String TAG = "ChartView";

    public ChartView(Context paramContext) {
        this(paramContext, null, 0);
    }

    public ChartView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public ChartView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                this.setLayerType(1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
    }

    private void initView() {
        this.mGestureDetector = new GestureDetector(getContext(), this);
        this.mGestureDetector.setOnDoubleTapListener(this);
        this.mScroller = new Scroller(getContext());
        setOnTouchListener(this);
    }

    public float getScale() {
        return this.mScale;
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent) {
        this.mScale = 1.0F;
        refreshPos();
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent paramMotionEvent) {
        if (!this.mScroller.isFinished())
            this.mScroller.forceFinished(true);
        this.mLastDistance = 0.0F;
        return true;
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);

        paramCanvas.drawColor(Color.WHITE);

        if ((this.mChart == null) || (!this.mChart.initOk())) {
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            boolean[] canScroll = this.mChart.getCanScroll();

            if (canScroll[0])    //能否左右滑动
            {
                this.mNowX = this.mScroller.getCurrX();
            }
            if (canScroll[1])    //能否上下滑动
            {
                this.mNowY = this.mScroller.getCurrY();
            }
            postInvalidate();
        }

        this.mChart.draw(paramCanvas, (int) this.mNowX, (int) this.mNowY, getWidth(), getHeight(), this.mScale);
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
        this.mScroller.forceFinished(true);
        int[] scrollRange = this.mChart.getScrollRange();
        this.mScroller.fling((int) this.mNowX, (int) this.mNowY, (int) paramFloat1, (int) paramFloat2, scrollRange[0], 0, scrollRange[1], 0);
        return true;
    }

    public void onLongPress(MotionEvent paramMotionEvent) {
        if (this.mChart.onLongClick(paramMotionEvent, this.mNowX, this.mNowY, getWidth(), getHeight(), this.mScale)) {
            invalidate();
        }
    }

    public boolean onScroll(MotionEvent MotionEvent1, MotionEvent MotionEvent2, float offsetX, float offsetY) {
        boolean[] canScroll = this.mChart.getCanScroll();
        if (!canScroll[0] && !canScroll[1]) {
            return false;
        }

        int[] scrollRange = this.mChart.getScrollRange();
        if (canScroll[0]) {
            this.mNowX -= offsetX;
            this.mNowX = Math.max(scrollRange[0], Math.min(this.mNowX, 0));
        }
        if (canScroll[1]) {
            this.mNowY -= offsetY;
            this.mNowY = Math.max(scrollRange[1], Math.min(this.mNowY, 0));
        }
        invalidate();
        return true;
    }

    public void onShowPress(MotionEvent paramMotionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
        return false;
    }

    public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
        if (this.mChart.onClick(paramMotionEvent, this.mNowX, this.mNowY, getWidth(), getHeight(), this.mScale)) {
            invalidate();
            return true;
        }
        return false;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.mChart != null) {
            this.mChart.initChart(getContext(), paramInt1, paramInt2, this.mScale);
        }
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void initChart(int w, int h) {
        this.mChart.initChart(getContext(), w, h, this.mScale);
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
        if ((this.mChart == null) || (!this.mChart.initOk())) {
            return false;
        }

        if ((this.mChart.getCanScale()) && (paramMotionEvent.getPointerCount() == 2) && (paramMotionEvent.getAction() == 2)) {
            float x_diff = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
            float y_diff = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
            float pos_diff = (float) Math.sqrt(x_diff * x_diff + y_diff * y_diff);        //两指之间距离

            if (this.mLastDistance == 0.0F) {
                this.mLastDistance = pos_diff;
            } else if (Math.abs(pos_diff - this.mLastDistance) > 10.0F)    //位移大于10
            {
                float[] scaleRange = this.mChart.getScaleRange();
                this.mScale = Math.max(scaleRange[0], Math.min(pos_diff * this.mScale / this.mLastDistance, scaleRange[1]));
                this.mLastDistance = pos_diff;
                refreshPos();
            }

            return true;
        } else if (paramMotionEvent.getPointerCount() < 2) {
            this.mLastDistance = 0.0F;
        }

        return this.mGestureDetector.onTouchEvent(paramMotionEvent);
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void refreshPos() {
        this.mScroller.forceFinished(true);
        if (this.mChart != null) {
            this.mChart.reCalcScroll(this.mScale, getWidth(), getHeight());
            int[] scrollRange = this.mChart.getScrollRange();
            this.mNowX = Math.min(0, Math.max(scrollRange[0], this.mNowX));
            this.mNowY = Math.min(0, Math.max(scrollRange[1], this.mNowY));
            invalidate();
        }
    }

    public void setChart(IChartDraw chart) {
        this.mChart = chart;
    }

    public void setNowX(float nowX) {
        this.mNowX = nowX;
        refreshPos();
    }

    public void setNowY(float nowY) {
        this.mNowY = nowY;
        refreshPos();
    }

    public void setScale(float scale) {
        this.mScale = scale;
        if ((this.mChart != null) && (this.mChart.getCanScale())) {
            float[] scaleRange = this.mChart.getScaleRange();
            this.mScale = Math.max(scaleRange[0], Math.min(this.mScale, scaleRange[1]));
        }
        refreshPos();
    }
}