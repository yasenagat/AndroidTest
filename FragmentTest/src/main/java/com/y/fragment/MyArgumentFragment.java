package com.y.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by zf on 2015/5/15.
 */
public class MyArgumentFragment extends Fragment {


    public static MyArgumentFragment newInstance(String str) {

        MyArgumentFragment lMyArgumentFragment = new MyArgumentFragment();

        Bundle lBundle = new Bundle();
        lBundle.putString("argument", str);
        lMyArgumentFragment.setArguments(lBundle);

        return lMyArgumentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TextView lTextView = new TextView(getActivity());
        Bundle lBundle = this.getArguments();
        lTextView.setText(lBundle == null ? "参数为空" : lBundle.getString("argument"));
        lTextView.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));

        return lTextView;
    }
}
