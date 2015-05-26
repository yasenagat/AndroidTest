package com.y;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.y.fragment.MyTabFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zf on 2015/5/16.
 */
public class TopTabActivity extends FragmentActivity {

    TabHost mTabHost;
    ViewPager mViewPager;
    TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toptab);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mViewPager = (ViewPager) findViewById(R.id.pager);

        mTabsAdapter = new TabsAdapter(this, mTabHost, mViewPager);

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
        mTabsAdapter.addTab(mTabHost.newTabSpec(tab1).setIndicator(createView(tab1, R.drawable.btn_invest_bg)), MyTabFragment.class, lBundle1);

        lBundle2.putString("argument", tab2);
        mTabsAdapter.addTab(mTabHost.newTabSpec(tab2).setIndicator(createView(tab2, R.drawable.btn_win_bg)), MyTabFragment.class, lBundle2);

        lBundle3.putString("argument", tab3);
        mTabsAdapter.addTab(mTabHost.newTabSpec(tab3).setIndicator(createView(tab3, R.drawable.btn_ci_bg)), MyTabFragment.class, lBundle3);

        lBundle4.putString("argument", tab4);
        mTabsAdapter.addTab(mTabHost.newTabSpec(tab4).setIndicator(createView(tab4, R.drawable.btn_account_bg)), MyTabFragment.class, lBundle4);

        lBundle5.putString("argument", tab5);
        mTabsAdapter.addTab(mTabHost.newTabSpec(tab5).setIndicator(createView(tab5, R.drawable.btn_more_bg)), MyTabFragment.class, lBundle5);

        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.gray_bg));
        }

        mTabHost.getTabWidget().setDividerDrawable(null);

        if (savedInstanceState != null) {
            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
    }

    public View createView(String title, int image) {

        View view = getLayoutInflater().inflate(R.layout.my_toptab, null);

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }

    /**
     * This is a helper class that implements the management of tabs and all
     * details of connecting a ViewPager with associated TabHost.  It relies on a
     * trick.  Normally a tab host has a simple API for supplying a View or
     * Intent that each tab will show.  This is not sufficient for switching
     * between pages.  So instead we make the content part of the tab host
     * 0dp high (it is not shown) and the TabsAdapter supplies its own dummy
     * view to show as the tab content.  It listens to changes in tabs, and takes
     * care of switch to the correct paged in the ViewPager whenever the selected
     * tab changes.
     */
    public static class TabsAdapter extends FragmentPagerAdapter
            implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener {
        private final Context mContext;
        private final TabHost mTabHost;
        private final ViewPager mViewPager;
        private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

        static final class TabInfo {
            private final String tag;
            private final Class<?> clss;
            private final Bundle args;

            TabInfo(String _tag, Class<?> _class, Bundle _args) {
                tag = _tag;
                clss = _class;
                args = _args;
            }
        }

        static class DummyTabFactory implements TabHost.TabContentFactory {
            private final Context mContext;

            public DummyTabFactory(Context context) {
                mContext = context;
            }

            @Override
            public View createTabContent(String tag) {
                View v = new View(mContext);
                v.setMinimumWidth(0);
                v.setMinimumHeight(0);
                return v;
            }
        }

        public TabsAdapter(FragmentActivity activity, TabHost tabHost, ViewPager pager) {
            super(activity.getSupportFragmentManager());
            mContext = activity;
            mTabHost = tabHost;
            mViewPager = pager;
            mTabHost.setOnTabChangedListener(this);
            mViewPager.setAdapter(this);
            mViewPager.setOnPageChangeListener(this);
        }

        public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
            tabSpec.setContent(new DummyTabFactory(mContext));
            String tag = tabSpec.getTag();

            TabInfo info = new TabInfo(tag, clss, args);
            mTabs.add(info);
            mTabHost.addTab(tabSpec);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mTabs.size();
        }

        @Override
        public Fragment getItem(int position) {
            TabInfo info = mTabs.get(position);
            return Fragment.instantiate(mContext, info.clss.getName(), info.args);
        }

        @Override
        public void onTabChanged(String tabId) {
            int position = mTabHost.getCurrentTab();
            mViewPager.setCurrentItem(position);
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            // Unfortunately when TabHost changes the current tab, it kindly
            // also takes care of putting focus on it when not in touch mode.
            // The jerk.
            // This hack tries to prevent this from pulling focus out of our
            // ViewPager.
            TabWidget widget = mTabHost.getTabWidget();
            int oldFocusability = widget.getDescendantFocusability();
            widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
            mTabHost.setCurrentTab(position);
            widget.setDescendantFocusability(oldFocusability);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }
}
