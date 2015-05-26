package com.y.fragment;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.y.R;

/**
 * Created by zf on 2015/5/15.
 */
public class MyArgumentFromXmlFragment extends Fragment {

    CharSequence mLabel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView lTextView = new TextView(getActivity());

        lTextView.setText(mLabel == null ? "空" : mLabel);
        lTextView.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));

        return lTextView;
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);

        TypedArray a = activity.obtainStyledAttributes(attrs,
                R.styleable.FragmentArguments);
        mLabel = a.getText(R.styleable.FragmentArguments_android_label);
        a.recycle();
    }
}
