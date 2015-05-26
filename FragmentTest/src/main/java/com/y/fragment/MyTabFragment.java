package com.y.fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.y.R;

import java.util.Random;

/**
 * Created by zf on 2015/5/15.
 */
public class MyTabFragment extends Fragment {

    private static final String KEY_ARGUMENT = "argument";

    private View rootView;// 缓存Fragment view

    public static MyTabFragment newInstance(String argument) {
        MyTabFragment lMyTabFragment = new MyTabFragment();
        Bundle lBundle = new Bundle();
        lBundle.putString(KEY_ARGUMENT, argument);
        lMyTabFragment.setArguments(lBundle);

        return lMyTabFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {

            rootView = new TextView(getActivity());

            TextView lTextView = (TextView) rootView;
            try {
                Bundle lBundle = this.getArguments();
                lTextView.setText(lBundle == null ? "参数为空" : lBundle.getString(KEY_ARGUMENT));

                lTextView.setBackgroundColor(getResources().getColor(R.color.white));
                lTextView.setTextColor(getResources().getColor(getColor()));
                lTextView.setTextSize(50);
                lTextView.setGravity(Gravity.CENTER);
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
                lTextView.setText("123");
            }
        }

        // 缓存的rootView需要判断是否已经被加过parent，如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }


        return rootView;
    }

    int[] colors = new int[]{ android.R.color.holo_blue_light, android.R.color.holo_green_dark, android.R.color.holo_purple, android.R.color.holo_blue_dark};

    public int getColor() {
        int index = new Random().nextInt(4);
        return colors[index];
    }
}
