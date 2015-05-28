package com.yasenagat;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zf on 2015/5/28.
 */
public class ResultActivity extends Activity {

    @InjectView(R.id.tv_result)
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.inject(this);

        String result = getIntent().getStringExtra("result");

        tv_result.setText(result);
    }
}
