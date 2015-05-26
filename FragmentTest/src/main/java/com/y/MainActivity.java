package com.y;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * Created by zf on 2015/5/15.
 */
public class MainActivity extends Activity {


//    @InjectView(R.id.btn_dialog)
//    Button btn_dialog;

    @InjectView(R.id.lv_item)
    ListView lv_item;

    private String[] items = new String[]{"Fragment弹出框",
            "Fragment传递参数",
            "Fragment底部选项卡(切换缓存状态)",
            "自定义样式的底部选项卡",
            "顶部选项卡滑动切换",
            "隐藏显示"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        lv_item.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return items.length;
            }

            @Override
            public Object getItem(int position) {
                return items[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                TextView lTextView = new TextView(MainActivity.this);
                lTextView.setText(items[position]);
                lTextView.setGravity(Gravity.CENTER);
                lTextView.setHeight(150);
                return lTextView;
            }
        });
    }

//    @OnClick(R.id.btn_dialog)
//    public void dialogOnClick() {
//
//
//    }

    @OnItemClick(R.id.lv_item)
    public void listItemClick(int position) {

        if (position == 0) {
            Intent intent = new Intent(MainActivity.this, AlertDialogActivity.class);
            startActivity(intent);
        } else if (position == 1) {
            Intent intent = new Intent(MainActivity.this, ArgumentActivity.class);
            startActivity(intent);
        } else if (position == 2) {
            Intent intent = new Intent(MainActivity.this, TabActivity.class);
            startActivity(intent);
        } else if (position == 3) {
            Intent intent = new Intent(MainActivity.this, MyTabActivity.class);
            startActivity(intent);
        } else if (position == 4) {
            Intent intent = new Intent(MainActivity.this, TopTabActivity.class);
            startActivity(intent);
        } else if (position == 5) {
            Intent intent = new Intent(MainActivity.this, HideShowActivity.class);
            startActivity(intent);
        }
    }
}
