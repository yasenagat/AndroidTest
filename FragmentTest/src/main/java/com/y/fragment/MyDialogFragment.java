package com.y.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.y.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by zf on 2015/5/15.
 */
@SuppressLint("NewApi")
public class MyDialogFragment extends DialogFragment {

    @InjectView(R.id.btn_close)
    Button btn_close;

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//        View lView = inflater.inflate(R.layout.dialog, container);
//        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(500, 500);
//
//        lView.setLayoutParams(layoutParams);
//        ButterKnife.inject(this, lView);
//
//
//        return lView;
//    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog lDialog = new Dialog(getActivity());
        lDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog, null, false);
        ButterKnife.inject(this, view);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int windowHeight = size.y;
        int windowWidth = size.x;

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(windowWidth, windowHeight);
        layoutParams.height = layoutParams.height / 2;
        layoutParams.width = layoutParams.width / 2;
        lDialog.setContentView(view, layoutParams);

        return lDialog;
    }

    @OnClick(R.id.btn_close)
    public void closeOnClick() {
        System.out.println("closeOnClick");
        this.dismiss();
    }
}
