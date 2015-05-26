package com.y;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zf on 2015/5/22.
 */
public class BallViewLinearLayout extends LinearLayout {



    private OnClickListener mOnClickListener;

    private List<View> mViews;

    private int column = 7;
    private int defualWeight = 1;

    private Context mContext;

    public BallViewLinearLayout(Context context) {
        super(context);
        mContext = context;
    }

    public BallViewLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public void setUp(Context context) {
        setGravity(Gravity.CENTER);
        setOrientation(VERTICAL);

        int yu = mViews.size() % column;
        int whole_time = (mViews.size() - yu) / column;

        for (int i = 0; i < whole_time; i++) {
            System.out.println(i);
            LinearLayout lLinearLayout = new LinearLayout(context);
            for (int j = 0; j < column; j++) {

                int index = i * column + j;
                System.out.println(index);
                mViews.get(index).setOnClickListener(mOnClickListener);
                addViewItem(lLinearLayout, mViews.get(index), defualWeight);
            }
            addView(lLinearLayout);
        }

        LinearLayout lLinearLayout = new LinearLayout(context);
        for (int i = 0; i < yu; i++) {
            int index = whole_time * column + i;
            System.out.println("index : " + index);
            mViews.get(index).setOnClickListener(mOnClickListener);
            addViewItem(lLinearLayout, mViews.get(index), defualWeight);
        }
        addViewItem(lLinearLayout, new View(mContext), (column - yu));

        addView(lLinearLayout);
    }

    private void addViewItem(LinearLayout linearLayout, View view, int weight) {
        view.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, weight));
        linearLayout.addView(view);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        System.out.println(widthMeasureSpec);
        System.out.println(heightMeasureSpec);
    }

    public List<View> getViews() {
        return mViews;
    }

    public void setViews(List<View> views) {
        mViews = views;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public void setUpOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }
}
