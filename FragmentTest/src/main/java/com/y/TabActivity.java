package com.y;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

import com.y.fragment.MyTabFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zf on 2015/5/15.
 */
public class TabActivity extends FragmentActivity {

    @InjectView(android.R.id.tabhost)
    FragmentTabHost mFragmentTabHost;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.inject(this);

        mFragmentTabHost.setup(TabActivity.this, getSupportFragmentManager(), R.id.realtabcontent);

        String tab1 = "购彩";
        String tab2 = "中奖";
        String tab3 = "合买";
        String tab4 = "账户";
        String tab5 = "更多";
        Bundle lBundle1 = new Bundle();
        Bundle lBundle2 = new Bundle();
        Bundle lBundle3 = new Bundle();
        Bundle lBundle4 = new Bundle();
        Bundle lBundle5 = new Bundle();

        lBundle1.putString("argument", tab1);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab1).setIndicator(tab1), MyTabFragment.class, lBundle1);
        lBundle2.putString("argument", tab2);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab2).setIndicator(tab2), MyTabFragment.class, lBundle2);
        lBundle3.putString("argument", tab3);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab3).setIndicator(tab3), MyTabFragment.class, lBundle3);
        lBundle4.putString("argument", tab4);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab4).setIndicator(tab4), MyTabFragment.class, lBundle4);
        lBundle5.putString("argument", tab5);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab5).setIndicator(tab5), MyTabFragment.class, lBundle5);

        mFragmentTabHost.setCurrentTab(2);
    }
}
