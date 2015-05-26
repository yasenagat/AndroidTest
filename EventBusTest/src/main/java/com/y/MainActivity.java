package com.y;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.logging.Handler;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

/**
 * Created by zf on 2015/5/13.
 */
public class MainActivity extends Activity {

    @InjectView(R.id.myBtn)
    Button myBtn;

    @InjectView(R.id.myBtn2)
    Button myBtn2;

    @InjectView(R.id.myTv)
    TextView myTv;

    @InjectView(R.id.myTv2)
    TextView myTv2;

    @InjectView(R.id.myTv3)
    TextView myTv3;

    @InjectView(R.id.myTv4)
    TextView myTv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        ButterKnife.inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @OnClick(R.id.myBtn)
    void myBtnClick() {
        EventBus.getDefault().post(new MessageEvent("Hello World"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new SomeOtherEvent("你好"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                    EventBus.getDefault().post(new MyMsg("自定义消息"));
                    System.out.println(123);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    // This method will be called when a MessageEvent is posted
    // Called in the same thread (default)
    public void onEvent(MessageEvent event) {
        Toast.makeText(MainActivity.this, event.message, Toast.LENGTH_SHORT).show();
    }

    // Called in Android UI's main thread
    public void onEventMainThread(MessageEvent event) {
        myTv.setText(event.message);
    }

    android.os.Handler lHandler = new android.os.Handler();

    // Called in the background thread
    public void onEventBackgroundThread(final SomeOtherEvent event) {

        lHandler.post(new Runnable() {
            @Override
            public void run() {
                myTv2.setText(event.message);
            }
        });

    }

    // Called in a separate thread
    public void onEventAsync(final MyMsg event) {
        lHandler.post(new Runnable() {
            @Override
            public void run() {
                myTv3.setText(event.message);
            }
        });
    }

    public void onEventAsync(final TimeEvent event) {
        lHandler.post(new Runnable() {
            @Override
            public void run() {
                myTv4.setText(event.time);
            }
        });
    }

    @OnClick(R.id.myBtn2)
    void myBtn2Click() {
        EventBus.getDefault().post(new TaskCancelEvent());
    }

}
