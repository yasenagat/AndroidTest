package com.y;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;
import butterknife.OnClick;

/**
 * Created by zf on 2015/5/12.
 */
public class MyActivity extends Activity {

    @InjectView(R.id.mybtn)
    Button mybtn;
    @InjectView(R.id.imageView)
    ImageView imageView;

    @InjectViews(R.id.imageView)
    List<View> mViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.mybtn)
    void mybtnClick() {
        Toast.makeText(MyActivity.this, "点击按钮", Toast.LENGTH_LONG).show();

        ButterKnife.apply(mViews, new ButterKnife.Action<View>() {
            @Override
            public void apply(View view, int index) {

                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);

                alphaAnimation.setFillBefore(true);
                alphaAnimation.setDuration(500);
                alphaAnimation.setStartOffset(index * 100);
                view.startAnimation(alphaAnimation);

//                view.setVisibility(View.GONE);
            }
        });
    }
}
