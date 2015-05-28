package com.y;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


import com.yasenagat.ballview.MyGridView;
import com.yasenagat.ballview.adaper.AbstractBallAdapter;
import com.yasenagat.ballview.adaper.impl.SSQ_BLUD_Adapter;
import com.yasenagat.ballview.adaper.impl.SSQ_RED_Adapter;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by zf on 2015/5/23.
 */
public class GridViewActivity extends Activity {

    private MyGridView mGridView, mGridView_blue;
    private SSQ_RED_Adapter mSSQ_red_adapter;
    private SSQ_BLUD_Adapter mSSQ_blue_adapter;
    private Button btn_getCode, btn_random, btn_clean, btn_ban, btn_miss, btn_coldhot;
    private Button btn_getCode_blue, btn_random_blue, btn_clean_blue, btn_ban_blue, btn_miss_blue, btn_coldhot_blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gridview);

        mGridView = (MyGridView) this.findViewById(R.id.gv);
        mGridView_blue = (MyGridView) this.findViewById(R.id.gv_blue);

        mSSQ_red_adapter = new SSQ_RED_Adapter(getApplicationContext());
        mSSQ_blue_adapter = new SSQ_BLUD_Adapter(getApplicationContext());

        mSSQ_red_adapter.getStateList().set(9, AbstractBallAdapter.STATE_PICK);
        mSSQ_red_adapter.getStateList().set(11, AbstractBallAdapter.STATE_DAN);

        for (int i = 0; i < mSSQ_red_adapter.getTextList().size(); i++) {

            mSSQ_red_adapter.getMissList().add(new Random().nextInt(100) + "");
            mSSQ_red_adapter.getColdHotList().add(new Random().nextInt(100) + "");
        }

        for (int i = 0; i < mSSQ_blue_adapter.getTextList().size(); i++) {

            mSSQ_blue_adapter.getMissList().add(new Random().nextInt(100) + "");
            mSSQ_blue_adapter.getColdHotList().add(new Random().nextInt(100) + "");
        }

        mSSQ_red_adapter.setMissFlag(35);
        mSSQ_red_adapter.setColdHotFlag(40);

        mSSQ_blue_adapter.setMissFlag(35);
        mSSQ_blue_adapter.setColdHotFlag(40);

        mGridView.setAdapter(mSSQ_red_adapter);
        mGridView_blue.setAdapter(mSSQ_blue_adapter);

        btn_getCode = (Button) this.findViewById(R.id.btn_getCode);
        btn_getCode_blue = (Button) this.findViewById(R.id.btn_getCode_blue);

        btn_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), mSSQ_red_adapter.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        btn_getCode_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), mSSQ_blue_adapter.getCode(), Toast.LENGTH_SHORT).show();

            }
        });

        btn_random = (Button) this.findViewById(R.id.btn_random);
        btn_random_blue = (Button) this.findViewById(R.id.btn_random_blue);

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSSQ_red_adapter.setDefautlState();

                Set<Integer> set = new HashSet<Integer>();
                while (true) {

                    set.add(new Random().nextInt(30));
                    if (set.size() >= 6) {
                        break;
                    }
                }

                for (Integer i : set) {
                    mSSQ_red_adapter.getStateList().set(i, AbstractBallAdapter.STATE_PICK);
                }

                mSSQ_red_adapter.notifyDataSetChanged();
            }
        });

        btn_random_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSSQ_blue_adapter.setDefautlState();

                Set<Integer> set = new HashSet<Integer>();
                while (true) {

                    set.add(new Random().nextInt(16));
                    if (set.size() >= 2) {
                        break;
                    }
                }

                for (Integer i : set) {
                    mSSQ_blue_adapter.getStateList().set(i, AbstractBallAdapter.STATE_PICK);
                }

                mSSQ_blue_adapter.notifyDataSetChanged();
            }
        });

        btn_clean = (Button) this.findViewById(R.id.btn_clean);
        btn_clean_blue = (Button) this.findViewById(R.id.btn_clean_blue);

        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_red_adapter.setDefautlState();
                mSSQ_red_adapter.notifyDataSetChanged();
            }
        });

        btn_clean_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_blue_adapter.setDefautlState();
                mSSQ_blue_adapter.notifyDataSetChanged();
            }
        });


        btn_ban = (Button) this.findViewById(R.id.btn_ban);
        btn_ban_blue = (Button) this.findViewById(R.id.btn_ban_blue);

        btn_ban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_red_adapter.setBan(!mSSQ_red_adapter.isBan());
                mSSQ_red_adapter.setDefautlState();
                mSSQ_red_adapter.notifyDataSetChanged();

            }
        });

        btn_ban_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_blue_adapter.setBan(!mSSQ_blue_adapter.isBan());
                mSSQ_blue_adapter.setDefautlState();
                mSSQ_blue_adapter.notifyDataSetChanged();
            }
        });


        btn_miss = (Button) this.findViewById(R.id.btn_miss);
        btn_miss_blue = (Button) this.findViewById(R.id.btn_miss_blue);

        btn_miss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_red_adapter.changeShowState2Miss();
                mSSQ_red_adapter.notifyDataSetChanged();
            }
        });

        btn_miss_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_blue_adapter.changeShowState2Miss();
                mSSQ_blue_adapter.notifyDataSetChanged();
            }
        });

        btn_coldhot = (Button) this.findViewById(R.id.btn_coldhot);
        btn_coldhot_blue = (Button) this.findViewById(R.id.btn_coldhot_blue);

        btn_coldhot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSSQ_red_adapter.changeShowState2ColdHot();
                mSSQ_red_adapter.notifyDataSetChanged();
            }
        });

        btn_coldhot_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mSSQ_blue_adapter.changeShowState2ColdHot();
                mSSQ_blue_adapter.notifyDataSetChanged();
            }
        });

    }


}
