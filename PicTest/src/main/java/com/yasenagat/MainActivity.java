package com.yasenagat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by zf on 2015/6/2.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SampleView sampleView = new SampleView(this);

        sampleView.setLayerType(1, null);
        setContentView(sampleView);
    }

    private static class SampleView extends View {
        private Picture mPicture;
        private Drawable mDrawable;

        static void drawSomething(Canvas canvas) {
            Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

            p.setColor(0x88FF0000);
            canvas.drawCircle(50, 50, 40, p);

            p.setColor(Color.GREEN);
            p.setTextSize(30);
            canvas.drawText("Pictures", 60, 60, p);
        }

        public SampleView(Context context) {
            super(context);
            setFocusable(true);
            setFocusableInTouchMode(true);

            mPicture = new Picture();
            drawSomething(mPicture.beginRecording(200, 100));
            mPicture.endRecording();

            mDrawable = new PictureDrawable(mPicture);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);

            canvas.drawPicture(mPicture);

            canvas.drawPicture(mPicture, new RectF(0, 100, getWidth(), 200));

            mDrawable.setBounds(0, 200, getWidth(), 300);
            mDrawable.draw(canvas);

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            mPicture.writeToStream(os);
            InputStream is = new ByteArrayInputStream(os.toByteArray());
            canvas.translate(0, 300);
            canvas.drawPicture(Picture.createFromStream(is));
        }


    }
}
