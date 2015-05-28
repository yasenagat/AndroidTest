package com.yasenagat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zf on 2015/5/28.
 */
public class MainActivity extends Activity {

    @InjectView(R.id.btn_scan)
    Button btn_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.btn_scan)
    public void scan(View view) {
        IntentIntegrator lIntentIntegrator = new IntentIntegrator(this);

        lIntentIntegrator.setCaptureActivity(MyCaptureActivity.class);

        lIntentIntegrator.initiateScan();
    }
}
