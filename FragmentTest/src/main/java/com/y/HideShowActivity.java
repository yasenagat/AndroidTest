package com.y;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.GridView;

import com.y.fragment.MyTabFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zf on 2015/5/16.
 */
public class HideShowActivity extends FragmentActivity {

    @InjectView(R.id.hideshow)
    Button btn_hideshow;
//    @InjectView(R.id.myf)
    MyTabFragment mMyf;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hideshow);
        ButterKnife.inject(this);

        mMyf = (MyTabFragment)getSupportFragmentManager().findFragmentById(R.id.myf);
    }

    @OnClick(R.id.hideshow)
    void hideShow() {

        FragmentTransaction lFragmentTransaction = getSupportFragmentManager().beginTransaction();
        lFragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        if (mMyf.isHidden()) {
            lFragmentTransaction.show(mMyf);
            btn_hideshow.setText("隐藏");
        } else {
            lFragmentTransaction.hide(mMyf);
            btn_hideshow.setText("显示");
        }

        lFragmentTransaction.commit();

    }
}
