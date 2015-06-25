package com.yasenagat.ui.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.util.Log;

/**
 * Created by zf on 2015/6/1.
 */
public abstract class AbstractSixPartDraw implements SixPartDraw {

    private static final String TAG =  "AbstractSixPartDraw";
    protected boolean init = false;

    public void init() {
        initPaint();

        drawLeftTop();
        drawLeftCenter();
        drawLeftBottom();

        drawCenterTop();
        drawCenter();
        drawCenterBottom();

        setInit(true);
    }

    public void initPaint(){
        this.mPaint.setTextAlign(Paint.Align.CENTER);
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    protected Picture mPictureLeftTop = new Picture();
    protected Picture mPictureLeftCenter = new Picture();
    protected Picture mPictureLeftBottom = new Picture();
    protected Picture mPictureCenterTop = new Picture();
    protected Picture mPictureCenter = new Picture();
    protected Picture mPictureCenterBottom = new Picture();

    protected Rect mRect = new Rect();

    protected Paint mPaint = new Paint(1);

    public void draw(Canvas canvas, int nowX, int nowY, int viewWidth, int viewHeight, float scale) {

        if ((viewWidth > 0) && (viewHeight > 0) && (isInit())) {
            int Y_width = (int) (scale * this.mPictureLeftCenter.getWidth());
            int Y_height = (int) (scale * this.mPictureLeftCenter.getHeight());

            int XTop_width = (int) (scale * this.mPictureCenterTop.getWidth());
            int XTop_height = (int) (scale * this.mPictureCenterTop.getHeight());

            int XBottom_width = (int) (scale * this.mPictureCenterBottom.getWidth());
            int XBottom_height = (int) (scale * this.mPictureCenterBottom.getHeight());

            int Data_width = (int) (scale * this.mPictureCenter.getWidth());
            int Data_height = (int) (scale * this.mPictureCenter.getHeight());

            Log.d(TAG,"Draw");

            canvas.save();
            this.mRect.set(Y_width, XTop_height, viewWidth, viewHeight - XBottom_height);
            canvas.clipRect(this.mRect);
            this.mRect.set(Y_width + nowX, XTop_height + nowY, Y_width + nowX + Data_width, XTop_height + nowY + Data_height);
            canvas.drawPicture(this.mPictureCenter, this.mRect);
            canvas.restore();

            this.mRect.set(Y_width + nowX, 0, Y_width + XTop_width + nowX, XTop_height);
            canvas.drawPicture(this.mPictureCenterTop, this.mRect);

            this.mRect.set(Y_width + nowX, viewHeight - XBottom_height, Y_width + nowX + XBottom_width, viewHeight);
            canvas.drawPicture(this.mPictureCenterBottom, this.mRect);

            this.mRect.set(0, XTop_height + nowY, Y_width, XTop_height + Y_height + nowY);
            canvas.drawPicture(this.mPictureLeftCenter, this.mRect);

            this.mRect.set(0, 0, Y_width, XTop_height);
            canvas.drawPicture(this.mPictureLeftTop, this.mRect);

            this.mRect.set(0, viewHeight - XBottom_height, Y_width, viewHeight);
            canvas.drawPicture(this.mPictureLeftBottom, this.mRect);
        }
    }
}
