package com.yasenagat.ballview.adaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yasenagat.ballview.R;

import java.util.List;

/**
 * Created by zf on 2015/5/23.
 */
public abstract class AbstractBallAdapter extends BaseAdapter {

    public abstract List<String> getTextList();

    public abstract List<String> getMissList();

    public abstract List<String> getColdHotList();

    public abstract List<Integer> getStateList();

    public abstract void setTextList(List<String> textList);

    public abstract void setMissList(List<String> missList);

    public abstract void setColdHotList(List<String> coldHotList);

    public abstract void setStateList(List<Integer> stateList);

    public abstract Context getContext();

    public abstract boolean checkState(int index);

    public abstract void changeState(int index);

    public abstract int getShowState();

    public abstract void setShowState(int showState);

    public abstract void changeShowState(int showState);

    public abstract void changeShowState2Miss();

    public abstract void changeShowState2ColdHot();

    public abstract void changeShowState2Null();

    public abstract int getMissFlag();

    public abstract int getColdHotFlag();

    public abstract void setMissFlag(int missFlag);

    public abstract void setColdHotFlag(int coldHotFlag);

    public abstract String getCode();

    public abstract boolean isBan();

    public abstract void setBan(boolean ban);


    @Override
    public int getCount() {
        return getTextList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder lViewHolder;
        if (convertView != null) {
            lViewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ball_item, parent, false);
            lViewHolder = new ViewHolder();

            lViewHolder.tv_ball = (TextView) convertView.findViewById(R.id.tv_ball);
            lViewHolder.tv_miss = (TextView) convertView.findViewById(R.id.tv_miss);
            lViewHolder.tv_coldhot = (TextView) convertView.findViewById(R.id.tv_coldhot);

            convertView.setTag(lViewHolder);
        }

        lViewHolder.tv_ball.setOnClickListener(createBallClickListener(position));
        setText(lViewHolder.tv_ball, getTextList().get(position), getStateList().get(position));

        if (getShowState() == SHOW_NULL) {
            hideText(lViewHolder.tv_miss);
            hideText(lViewHolder.tv_coldhot);
        } else if (getShowState() == SHOW_MISS) {
            setMissText(lViewHolder.tv_miss, getMissList().get(position));
            hideText(lViewHolder.tv_coldhot);
        } else if (getShowState() == SHOW_COLDHOT) {
            setColdHotText(lViewHolder.tv_coldhot, getColdHotList().get(position));
            hideText(lViewHolder.tv_miss);
        }

        return convertView;
    }

    protected View.OnClickListener createBallClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkState(position)) {
                    changeState(position);
                    notifyDataSetChanged();
                }
            }
        };
    }


    protected void setText(TextView textView, String text, int state) {

        textView.setText(getTextByState(text, state));
        textView.setTextAppearance(getContext(), getStyleByState(state));
        textView.setBackgroundResource(getBackGroundResourceByState(state));
    }

    protected void setText(TextView textView, String text) {
        textView.setText(text);
        textView.setVisibility(View.VISIBLE);
    }

    protected void setMissText(TextView textView, String text) {
        if (Integer.valueOf(text) > getMissFlag()) {
            textView.setTextColor(getContext().getResources().getColor(R.color.red));
        }
        textView.setText(text);
        textView.setVisibility(View.VISIBLE);
    }

    protected void setColdHotText(TextView textView, String text) {
        if (Integer.valueOf(text) > getMissFlag()) {
            textView.setTextColor(getContext().getResources().getColor(R.color.red));
        }
        textView.setText(text);
        textView.setVisibility(View.VISIBLE);
    }

    protected void hideText(TextView textView) {
        textView.setVisibility(View.GONE);
    }

    class ViewHolder {
        TextView tv_ball;
        TextView tv_miss;
        TextView tv_coldhot;
    }


    /**
     * **
     */
    public static final int SHOW_NULL = 1;
    public static final int SHOW_MISS = 2;
    public static final int SHOW_COLDHOT = 3;

    public static final int STATE_NO_PICK = 1;
    public static final int STATE_PICK = 2;
    public static final int STATE_DAN = 3;
    public static final int STATE_BAN = 4;

    /**
     * **
     */

    protected int getStyleByState(int state) {
        int style = R.style.State_No_Pick_Red;
        if (state == STATE_NO_PICK) {
            style = R.style.State_No_Pick_Red;
        } else if (state == STATE_PICK) {
            style = R.style.State_Pick_Red;
        } else if (state == STATE_DAN) {
            style = R.style.State_Dan_Red;
        } else if (state == STATE_BAN) {
            style = R.style.State_Ban_Red;
        }
        return style;
    }

    protected int getBackGroundResourceByState(int state) {
        int bg_resource_id = R.drawable.ball_red_n;
        if (state == STATE_NO_PICK) {
            bg_resource_id = R.drawable.ball_red_n;
        } else if (state == STATE_PICK) {
            bg_resource_id = R.drawable.ball_red;
        } else if (state == STATE_DAN) {
            bg_resource_id = R.drawable.ball_red;
        } else if (state == STATE_BAN) {
            bg_resource_id = R.drawable.ball_red_ban_p;
        }
        return bg_resource_id;
    }

    protected String getTextByState(String text, int state) {

        if (state == STATE_DAN) {
            return "胆";
        } else {
            return text;
        }
    }

}
