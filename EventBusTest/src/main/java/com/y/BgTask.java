package com.y;

import de.greenrobot.event.EventBus;

/**
 * Created by zf on 2015/5/13.
 */
public class BgTask implements Runnable {

    private static transient boolean cancel = false;
    private static long time = 99;


    public BgTask() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void run() {

        while (!cancel) {

            try {
                Thread.sleep(1000);
                time--;
                EventBus.getDefault().post(new TimeEvent(String.valueOf(time)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(TaskCancelEvent event) {
        cancel = true;
    }

}
