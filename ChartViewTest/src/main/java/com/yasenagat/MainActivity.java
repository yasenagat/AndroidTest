package com.yasenagat;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yasenagat.ui.chart.ScaleScrollView;
import com.yasenagat.ui.chart.TestSixPartDraw;

/**
 * Created by zf on 2015/5/29.
 */
public class MainActivity extends Activity {

    private static String TAG = "MainActivity";
    ScaleScrollView ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScaleScrollView lScaleScrollView = new ScaleScrollView(MainActivity.this);
        lScaleScrollView.setLayerType(1,null);
        setContentView(lScaleScrollView);
//        setContentView(R.layout.activity_main);
//
//        ss = (ScaleScrollView) this.findViewById(R.id.ss);

//        Canvas lCanvas = new Canvas();
//        TestSixPartDraw lTestSixPartDraw = new TestSixPartDraw();
//        lTestSixPartDraw.init();
//        lTestSixPartDraw.draw(lCanvas, 0, 0, 500, 100, 1f);
//
//        setContentView(lCanvas);
    }


}
