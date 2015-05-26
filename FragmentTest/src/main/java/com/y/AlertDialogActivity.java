package com.y;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Button;

import com.y.fragment.MyDialogFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zf on 2015/5/15.
 */
@SuppressLint("NewApi")
public class AlertDialogActivity extends FragmentActivity {


    @InjectView(R.id.btn_showDialog)
    Button btn_showDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);
        ButterKnife.inject(this);


    }

    @OnClick(R.id.btn_showDialog)
    void showDialogClick() {
        System.out.println("showDialogClick");
        final MyDialogFragment lDialogFragment = new MyDialogFragment();
        lDialogFragment.setCancelable(false);

        lDialogFragment.show(getSupportFragmentManager(), "lDialogFragment");
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    Thread.sleep(1500);
//                    lDialogFragment.dismiss();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }
}
