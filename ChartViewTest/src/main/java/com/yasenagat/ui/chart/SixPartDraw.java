package com.yasenagat.ui.chart;

/**
 * Created by zf on 2015/6/1.
 * <p/>
 * <p/>
 * *****************|*******************************************
 * ****LeftTop******|*****************CenterTop*****************
 * *****************|*******************************************
 * -----------------|-------------------------------------------
 * *****************|*******************************************
 * *****************|*******************************************
 * *****************|*******************************************
 * ****LeftCenter***|*****************Center********************
 * *****************|*******************************************
 * *****************|*******************************************
 * *****************|*******************************************
 * -----------------|-------------------------------------------
 * *****************|*******************************************
 * ****LeftBottom***|*****************CenterBottom**************
 * *****************|*******************************************
 */
public interface SixPartDraw {

    abstract void drawLeftTop();

    abstract void drawLeftCenter();

    abstract void drawLeftBottom();

    abstract void drawCenterTop();

    abstract void drawCenter();

    abstract void drawCenterBottom();


    /*abstract void drawRightTop();

    abstract void drawRightCenter();

    abstract void drawRightBottom();*/

}