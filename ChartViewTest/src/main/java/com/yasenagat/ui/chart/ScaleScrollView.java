package com.yasenagat.ui.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zf on 2015/5/29.
 */
public class ScaleScrollView extends View implements View.OnTouchListener, GestureDetector.OnGestureListener {

    private static final String TAG = "ScaleScrollView";

    private Context mContext;
    private float last_d;

    public ScaleScrollView(Context context) {
        super(context);
        init(context);
    }

    public ScaleScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScaleScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ScaleScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

        try {
            if (Build.VERSION.SDK_INT >= 11) {
                this.setLayerType(1, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        mContext = context;
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        TestSixPartDraw lTestSixPartDraw = new TestSixPartDraw();
//        lTestSixPartDraw.init();
//        lTestSixPartDraw.draw(canvas, 0, 0, 500, 100, 1f);

        Picture lPicture = new Picture();
        Canvas lCanvas = lPicture.beginRecording(100, 100);
        lCanvas.drawColor(Color.WHITE);
        Paint lPaint = new Paint();
        lPaint.setTextSize(30);
        lPaint.setTextAlign(Paint.Align.CENTER);
        lPaint.setColor(Color.RED);
        lCanvas.drawText("123", 50, 50, lPaint);

        Rect lRect = new Rect(0, 0, 100, 100);
        canvas.drawPicture(lPicture, lRect);

        Picture lPicture2 = new Picture();
        Canvas lCanvas2 = lPicture2.beginRecording(100, 100);

        Paint lPaint2 = new Paint();
        lPaint2.setTextSize(30);
        lPaint2.setTextAlign(Paint.Align.CENTER);
        lPaint2.setColor(Color.RED);
        lCanvas2.drawText("abc", 150, 150, lPaint2);

        Rect lRect2 = new Rect(100, 100, 200, 200);
        lPaint2.setColor(Color.GREEN);
        canvas.drawRect(lRect2,lPaint2);
        canvas.drawPicture(lPicture2, lRect2);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG, "onTouch " + " event.getAction() : " + event.getAction());

        if (event.getPointerCount() == 2 && event.getAction() == MotionEvent.ACTION_MOVE) {

            Log.d(TAG, "两个手指，且滑动");
            float x = event.getX(0) - event.getX(1);
            float y = event.getY(0) - event.getY(1);
            float d = (float) Math.sqrt(x * x + y * y);
            float change = Math.abs(d - last_d);

            if (last_d != 0) {

                last_d = d;

                if (change > 10f) {
                    Log.d(TAG, "距离变化超过10f : " + change);
                } else {
                    Log.d(TAG, "距离变化: " + change);
                }

            } else {
                last_d = d;
            }

            return true;
        }

        return new GestureDetector(mContext, this).onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return true;
    }
}
