package com.yasenagat.ballview.adaper;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf on 2015/5/23.
 */
public class DefaultAdapter extends AbstractBallAdapter {

    public List<String> textList = new ArrayList<String>();
    public List<String> missList = new ArrayList<String>();
    public List<String> coldhotList = new ArrayList<String>();
    public List<Integer> stateList = new ArrayList<Integer>();
    public boolean ban;

    private Context context;

    private int missFlag = Integer.MAX_VALUE;
    private int coldHotFlag = Integer.MAX_VALUE;
    private int showState = SHOW_MISS;

    public DefaultAdapter(Context context) {
        this.context = context;
    }

    @Override
    public List<String> getTextList() {
        return this.textList;
    }

    @Override
    public List<String> getMissList() {
        return missList;
    }

    @Override
    public List<String> getColdHotList() {
        return coldhotList;
    }

    @Override
    public List<Integer> getStateList() {
        return stateList;
    }

    @Override
    public void setTextList(List<String> textList) {
        this.textList = textList;
    }

    @Override
    public void setMissList(List<String> missList) {
        this.missList = missList;
    }

    @Override
    public void setColdHotList(List<String> coldHotList) {
        this.coldhotList = coldHotList;
    }

    @Override
    public void setStateList(List<Integer> stateList) {
        this.stateList = stateList;
    }

    @Override
    public Context getContext() {
        return this.context;
    }

    @Override
    public boolean checkState(int index) {
        return true;
    }

    @Override
    public void changeState(int index) {
        int state = getStateList().get(index);

        if (isBan()) {
            if (state == STATE_NO_PICK) {
                state = STATE_DAN;
            } else if (state == STATE_DAN) {
                state = STATE_BAN;
            } else if (state == STATE_BAN) {
                state = STATE_NO_PICK;
            } else if (state == STATE_PICK) {
                state = STATE_NO_PICK;
            }
        } else {
            if (state == STATE_NO_PICK) {
                state = STATE_PICK;
            } else if (state == STATE_PICK) {
                state = STATE_DAN;
            } else if (state == STATE_DAN) {
                state = STATE_NO_PICK;
            }
        }

        getStateList().set(index, state);
    }

    protected void initDefautlState() {
        for (String text : getTextList()) {
            getStateList().add(STATE_NO_PICK);
        }
    }

    public void setDefautlState() {
        for (int i = 0; i < getStateList().size(); i++) {
            getStateList().set(i, STATE_NO_PICK);
        }
    }

    @Override
    public int getShowState() {
        return showState;
    }

    @Override
    public void setShowState(int showState) {
        this.showState = showState;
    }

    @Override
    public int getMissFlag() {
        return missFlag;
    }

    @Override
    public int getColdHotFlag() {
        return coldHotFlag;
    }

    @Override
    public void setMissFlag(int missFlag) {
        this.missFlag = missFlag;
    }

    @Override
    public void setColdHotFlag(int coldHotFlag) {
        this.coldHotFlag = coldHotFlag;
    }

    @Override
    public String getCode() {

        StringBuffer code = new StringBuffer();

        List<String> tuo = new ArrayList<String>();
        List<String> dan = new ArrayList<String>();

        for (int i = 0; i < getStateList().size(); i++) {

            if (getStateList().get(i) == STATE_PICK) {
                tuo.add(getTextList().get(i));
            } else if (getStateList().get(i) == STATE_DAN) {
                dan.add(getTextList().get(i));
            }
        }

        for (int i = 0; i < dan.size(); i++) {
            code.append(dan.get(i));

            if (i != dan.size() - 1) {
                code.append(",");
            }
        }

        if (dan.size() > 0) {
            code.append("*");
        }

        for (int i = 0; i < tuo.size(); i++) {
            code.append(tuo.get(i));

            if (i != tuo.size() - 1) {
                code.append(",");
            }
        }

        return code.toString();
    }

    @Override
    public boolean isBan() {
        return ban;
    }

    @Override
    public void setBan(boolean ban) {
        this.ban = ban;
    }

    @Override
    public void changeShowState(int showState) {
        if (this.getShowState() == showState) {
            this.setShowState(AbstractBallAdapter.SHOW_NULL);
        } else {
            this.setShowState(showState);
        }
    }

    public void changeShowState2Miss() {
        this.changeShowState(SHOW_MISS);
    }

    public void changeShowState2ColdHot() {
        this.changeShowState(SHOW_COLDHOT);
    }

    public void changeShowState2Null() {
        this.setShowState(AbstractBallAdapter.SHOW_NULL);
    }

}
