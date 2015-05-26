package com.dgcy.http.util;

import android.util.Log;

/**
 * Created by zf on 2015/5/11.
 */
public class HttpLog {

    private static final String DEFAULTTAG = "com.dgcy.lty.sdk.android.http";
    private static boolean httpDebug = true;
    public static void debug(String tag, String msg) {
        if (httpDebug) {
            Log.d(tag, msg);
        }
    }

    public static void warn(String tag, String msg) {
        if (httpDebug) {
            Log.w(tag, msg);
        }
    }

    public static void debug(String msg) {
        if (httpDebug) {
            Log.d(DEFAULTTAG, msg);
        }
    }
}
