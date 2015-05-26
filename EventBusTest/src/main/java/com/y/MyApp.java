package com.y;

import android.app.Application;

/**
 * Created by zf on 2015/5/13.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new BgTask()).start();
    }
}
