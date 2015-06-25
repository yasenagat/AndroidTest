package com.yasenagat.chartview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Rect;
import android.view.MotionEvent;

public abstract class AbstractChartDraw implements IChartDraw {

    private static final String TAG = "AbstractChartDraw";

    protected static final int Width_Y_qyh = 60;        //Y轴坐标宽度
    protected static final int Width_Y = 50;        //Y轴坐标宽度
    protected static final int Height_XTop = 30;
    protected static final int Height_XBottom = 50;
    protected static final int Height_BottomMargin = 5;

    protected static final int Width_Data = 30;
    protected static final int Height_Data = 30;

    protected static final int Width_Div = 10;
    protected static final int Height_Div = 10;

    protected static final int Width_Div_Bigsamll = 2;

    //缺省背景色
    protected static final int ColorBGDefault = Color.WHITE;

    //统计背景色
    protected static final int ColorBGCount_1 = Color.WHITE;
    protected static final int ColorBGCount_2 = 0xFFE9F1DC;
    protected static final int ColorBGCount_3 = Color.WHITE;
    protected static final int ColorBGCount_4 = 0xFFFEF8E3;

    //分割线色
    protected static final int ColorSepLine = 0xF0F0F0F0;
    protected static final int ColorDivDG = Color.WHITE;

    //左上角
    protected final Picture mPicLeftTop = new Picture();
    protected static final int ColorBGLeftTop = 0xFFF5F5F5;
    protected static final int ColorTextLeftTop = Color.BLACK;
    protected static final int TextSizeLeftTop = 10;

    //左下角
    protected final Picture mPicLeftBottom = new Picture();
    protected static final int ColorBGLeftBottom = Color.WHITE;
    protected static final int ColorTextLeftBottom = Color.BLACK;
    protected static final int TextSizeLeftBottom = 10;

    //XTop
    protected final Picture mPicXTop = new Picture();
    protected static final int ColorBGXTop = 0xFFDAD2CA;
    protected static final int ColorTextXTop = Color.WHITE;
    protected static final int TextSizeXTop = 10;

    //XBottom
    protected final Picture mPicXBottom = new Picture();
    protected static final int ColorBGXBottom = Color.WHITE;
    protected static final int ColorTextXBottomUnSelect = Color.RED;
    protected static final int ColorTextXBottomSelect = Color.WHITE;
    protected static final int TextSizeXBottom = 10;

    //Y轴
    protected final Picture mPicY = new Picture();
    protected static final int ColorBGYOdd = 0xFFEDECEA;
    protected static final int ColorBGYEven = 0xFFE8E4DE;
    protected static final int ColorTextY = Color.BLACK;
    protected static final int TextSizeY = 10;

    //4行统计列首字色
    protected static final int ColorTextY_1 = 0xFF5D8ADF;
    protected static final int ColorTextY_2 = 0xFF6FB949;
    protected static final int ColorTextY_3 = 0xFFD76969;
    protected static final int ColorTextY_4 = 0xFF80756E;

    //数据
    protected final Picture mPicContent = new Picture();
    protected static final int ColorBGDataOdd = Color.WHITE;
    protected static final int ColorBGDataEven = 0xFFF6F6F6;
    protected static final int TextSizeData = 10;
    protected static final int BallTextSize = 10;
    protected static final int ColorTextMiss = 0xFF9E9E9E;
    protected static final int ColorTextCount = Color.BLACK;
    protected static final int ColorBlueLinkLine = 0xFF6DACED;
    protected static final int ColorRedLinkLine = 0xFFDC6161;

    //球大小
    protected static final int DefBallSize = 12;
    protected static final int ColorBallRed = 0xFFDC6161;//0xFFDC6161;
    protected static final int ColorBallBlue = 0xFF6DACED;

    protected boolean mCanScale = true;
    protected boolean[] mCanScroll = {true, true};

    protected boolean mInitOk = false;

    protected Paint mPaint = new Paint(1);
    protected Paint mPaintLine = new Paint(1);
    protected static final int Width_Line = 5;
    protected Rect mRect = new Rect();

    //放缩比例范围最小，最大
    protected float[] mScaleRange = {0.1F, 2.0F};
    protected int[] mScrollRange = new int[2];

    protected ChartView mTrendView;

    protected int ColorDivLine = 0xFFbdb9b3;

    public AbstractChartDraw(Context paramContext, ChartView view) {
        this.mTrendView = view;
        if (null != this.mTrendView) {
            this.mTrendView.setChart(this);
        }
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaintLine.setTextAlign(Paint.Align.CENTER);
        this.mPaintLine.setStrokeWidth(Width_Line);
    }

    public void draw(Canvas canvas, int nowX, int nowY, int viewWidth, int viewHeight, float scale) {
        if ((viewWidth > 0) && (viewHeight > 0) && (initOk())) {
            int Y_width = (int) (scale * this.mPicY.getWidth());
            int Y_height = (int) (scale * this.mPicY.getHeight());

            int XTop_width = (int) (scale * this.mPicXTop.getWidth());
            int XTop_height = (int) (scale * this.mPicXTop.getHeight());

            int XBottom_width = (int) (scale * this.mPicXBottom.getWidth());
            int XBottom_height = (int) (scale * this.mPicXBottom.getHeight());

            int Data_width = (int) (scale * this.mPicContent.getWidth());
            int Data_height = (int) (scale * this.mPicContent.getHeight());

            //数据
            canvas.save();
            this.mRect.set(Y_width, XTop_height, viewWidth, viewHeight - XBottom_height);
            canvas.clipRect(this.mRect);
            this.mRect.set(Y_width + nowX, XTop_height + nowY, Y_width + nowX + Data_width, XTop_height + nowY + Data_height);
            canvas.drawPicture(this.mPicContent, this.mRect);
            canvas.restore();

            //行首
            this.mRect.set(Y_width + nowX, 0, Y_width + XTop_width + nowX, XTop_height);
            canvas.drawPicture(this.mPicXTop, this.mRect);

            //行尾
            this.mRect.set(Y_width + nowX, viewHeight - XBottom_height, Y_width + nowX + XBottom_width, viewHeight);
            canvas.drawPicture(this.mPicXBottom, this.mRect);

            //Y轴
            this.mRect.set(0, XTop_height + nowY, Y_width, XTop_height + Y_height + nowY);
            canvas.drawPicture(this.mPicY, this.mRect);

            //左上
            this.mRect.set(0, 0, Y_width, XTop_height);
            canvas.drawPicture(this.mPicLeftTop, this.mRect);

            //左下
            this.mRect.set(0, viewHeight - XBottom_height, Y_width, viewHeight);
            canvas.drawPicture(this.mPicLeftBottom, this.mRect);
        }
    }

    protected abstract void drawContent();

    protected abstract void drawLeftBottom();

    protected abstract void drawLeftTop();

    protected abstract void drawXBottom();

    protected abstract void drawXTop();

    protected abstract void drawY();

    protected int dp2px(float paramFloat, int paramInt) {
        return (int) (0.5F + paramFloat * paramInt);
    }

    protected void drawBall2Rect(int color, Canvas canvas, Rect paramRect, float radius, Paint p) {
        if (color < 0) {
            p.setStyle(Paint.Style.STROKE);
            p.setColor(-color);
        } else {
            p.setStyle(Paint.Style.FILL);
            p.setColor(color);
        }

        canvas.drawCircle(paramRect.exactCenterX(), paramRect.centerY(), radius, p);
    }

    protected void drawBitmap2Rect(Bitmap paramBitmap, Canvas paramCanvas, Rect paramRect, Paint paramPaint) {
        paramCanvas.drawBitmap(paramBitmap, paramRect.centerX() - paramBitmap.getWidth() / 2, paramRect.centerY() - paramBitmap.getHeight() / 2, paramPaint);
    }

    //写字

    protected void drawText2Rect(Canvas canvas, String text, int fontSize, int textColor, int rectLeft, int rectTop, int rectRight, int rectBottom) {
        if (null != text)//&& !text.isEmpty())
        {
            this.mRect.set(rectLeft, rectTop, rectRight, rectBottom);

            this.mPaint.setColor(textColor);
            this.mPaint.setTextSize(fontSize);
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();

            canvas.drawText(text, this.mRect.centerX(), this.mRect.top + (this.mRect.bottom - this.mRect.top - localFontMetrics.bottom + localFontMetrics.top) / 2.0F - localFontMetrics.top, this.mPaint);
        }
    }

    //写字代背景
    protected void drawText2Rect(Canvas canvas, String text, int fontSize, int textColor, int rectLeft, int rectTop, int rectRight, int rectBottom, int fillColor) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(fillColor);
        this.mRect.set(rectLeft, rectTop, rectRight, rectBottom);
        canvas.drawRect(this.mRect, this.mPaint);

        if (null != text)// && !text.isEmpty())
        {
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            this.mPaint.setColor(textColor);
            this.mPaint.setTextSize(fontSize);
            Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();

            canvas.drawText(text, this.mRect.centerX(), this.mRect.top + (this.mRect.bottom - this.mRect.top - localFontMetrics.bottom + localFontMetrics.top) / 2.0F - localFontMetrics.top, this.mPaint);
        }
    }

    //画矩形
    protected void drawRect(Canvas canvas, int rectLeft, int rectTop, int rectRight, int rectBottom, int fillColor) {
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(fillColor);
        this.mRect.set(rectLeft, rectTop, rectRight, rectBottom);
        canvas.drawRect(this.mRect, this.mPaint);
    }

    //写字代背景
    protected void drawText2Circle(Canvas canvas, String text, int fontSize, int textColor,
                                   int rectLeft, int rectTop, int rectRight, int rectBottom,
                                   int circleSize, int circleColor, boolean isFill) {
        if (isFill) {
            this.mPaint.setStyle(Paint.Style.FILL);
        } else {
            this.mPaint.setStyle(Paint.Style.STROKE);
        }

        this.mPaint.setColor(circleColor);
        this.mRect.set(rectLeft, rectTop, rectRight, rectBottom);

        //画圆
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), circleSize, this.mPaint);

        //写字
        this.drawText2Rect(canvas, text, fontSize, textColor, rectLeft, rectTop, rectRight, rectBottom);
    }

    //画线
    protected void drawLine(Canvas canvas, int startX, int startY, int endX, int endY, int lineColor) {
        this.mPaint.setColor(lineColor);
        canvas.drawLine(startX, startY, endX, endY, this.mPaint);
    }

    protected void drawLineWidth(Canvas canvas, int startX, int startY, int endX, int endY, int lineColor) {
        this.mPaintLine.setColor(lineColor);
        canvas.drawLine(startX, startY, endX, endY, this.mPaintLine);
    }

    //画线
    protected void drawPath(Canvas canvas, Path path, int lineColor) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(lineColor);
        canvas.drawPath(path, this.mPaint);
    }

    public boolean getCanScale() {
        return this.mCanScale;
    }

    public boolean[] getCanScroll() {
        return this.mCanScroll;
    }

    public float[] getScaleRange() {
        return this.mScaleRange;
    }

    public int[] getScrollRange() {
        return this.mScrollRange;
    }

    //初始化视图
    public void initChart(Context paramContext, int paramInt1, int paramInt2, float scale) {
        if ((paramInt1 != 0) && (paramInt2 != 0)) {
            drawXTop();
            drawLeftTop();
            drawY();
            drawXBottom();
            drawContent();
            drawLeftBottom();

            this.mInitOk = true;
        }
    }

    public boolean initOk() {
        return this.mInitOk;
    }

    public boolean onClick(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3) {
        return false;
    }

    public boolean onLongClick(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3) {
        return false;
    }

    //算位移的最大最小
    public void reCalcScroll(float scale, int viewWight, int viewHeight) {
        if ((this.mPicY == null) || (this.mPicXTop == null) || (this.mPicXBottom == null)) {
            return;
        }

        int Y_width = this.mPicY.getWidth();                                            //期宽度，行数据起始位置
        int Y_height = this.mPicY.getHeight();                                        //期高度，列高
        int XTop_width = this.mPicXTop.getWidth();                                //行首宽度
        int XTop_height = this.mPicXTop.getHeight();                            //行首高度

        int XBottom_height = this.mPicXBottom.getHeight();

        this.mScrollRange[0] = (int) (viewWight - scale * (XTop_width + Y_width));
        this.mScrollRange[1] = (int) (viewHeight - scale * (Y_height + XTop_height + XBottom_height));        //最大

        //放缩最小比例，取XY中放缩的大值

        //X缩比例最小多少
        float scale_cal = 1.0F * viewWight / (Y_width + XTop_width);
        if (scale_cal > this.mScaleRange[0]) {
            this.mScaleRange[0] = scale_cal;
        }

        //Y缩比例最小多少
        scale_cal = 1.0F * viewHeight / (Y_height + XTop_height + XBottom_height);
        if (scale_cal > this.mScaleRange[0]) {
            this.mScaleRange[0] = scale_cal;
        }
    }

    public void setInitOk(boolean isOK) {
        this.mInitOk = isOK;
    }
}