package com.y;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.y.fragment.MyArgumentFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zf on 2015/5/15.
 */
public class ArgumentActivity extends FragmentActivity {

    @InjectView(R.id.fl_fromCode)
    FrameLayout fl_fromCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argument);
        ButterKnife.inject(this);
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.add(R.id.fl_fromCode, MyArgumentFragment.newInstance("从代码中设置的参数"));
            ft.commit();
        }
    }
}
