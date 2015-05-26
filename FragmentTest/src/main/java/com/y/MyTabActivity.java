package com.y;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.y.fragment.MyTabFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by zf on 2015/5/16.
 */
@SuppressLint("NewApi")
public class MyTabActivity extends FragmentActivity {

    @InjectView(android.R.id.tabhost)
    FragmentTabHost mFragmentTabHost;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.inject(this);

        mFragmentTabHost.setup(MyTabActivity.this, getSupportFragmentManager(), R.id.realtabcontent);

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
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab1).setIndicator(createView(tab1, R.drawable.btn_invest_bg)), MyTabFragment.class, lBundle1);

        lBundle2.putString("argument", tab2);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab2).setIndicator(createView(tab2, R.drawable.btn_win_bg)), MyTabFragment.class, lBundle2);

        lBundle3.putString("argument", tab3);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab3).setIndicator(createView(tab3, R.drawable.btn_ci_bg)), MyTabFragment.class, lBundle3);

        lBundle4.putString("argument", tab4);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab4).setIndicator(createView(tab4, R.drawable.btn_account_bg)), MyTabFragment.class, lBundle4);

        lBundle5.putString("argument", tab5);
        mFragmentTabHost.addTab(mFragmentTabHost.newTabSpec(tab5).setIndicator(createView(tab5, R.drawable.btn_more_bg)), MyTabFragment.class, lBundle5);

        for (int i = 0; i < mFragmentTabHost.getTabWidget().getChildCount(); i++) {
            mFragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.gray_bg));
        }

        mFragmentTabHost.getTabWidget().setDividerDrawable(null);

        mFragmentTabHost.setCurrentTab(2);
    }


    public View createView(String title, int image) {

        View view = getLayoutInflater().inflate(R.layout.mytab, null);

        TabView lTabView = new TabView(view);

        lTabView.tab_title.setText(title);
        lTabView.tab_image.setImageResource(image);

        return view;
    }

    public class TabView {


        @InjectView(R.id.tab_title)
        TextView tab_title;


        @InjectView(R.id.tab_image)
        ImageView tab_image;

        public TabView(View view) {

            ButterKnife.inject(this, view);
        }
    }

}
