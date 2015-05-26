package com.dgcy.client;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.dgcy.http.base.IRequestMsg;
import com.dgcy.http.base.IResponseListener;
import com.dgcy.http.cache.CacheManager;

import java.io.File;

/**
 * Created by zf on 2015/5/11.
 */
public class HttpClientFactory {

    public static IHttpClient sIHttpClient = new RocketClient();

    private HttpClientFactory() {
    }

    public static void init(Context context) {

        sIHttpClient.init(context);
        CacheManager.INSTANCE.init(context.getCacheDir().getAbsolutePath() + File.separator + "Y");
    }

//    public static <T> void asyncRequest(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener) throws Exception {
//        if (sIHttpClient.initSuccess()) {
//
//            try {
//                sIHttpClient.before(requestMsg);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            sIHttpClient.asyncRequest(requestMsg, responseListener);
//            try {
//                sIHttpClient.after(requestMsg);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

    public static <T> void asyncRequest(IRequestMsg<T> requestMsg, IResponseListener<T> responseListener, Object tag) throws Exception {
        if (sIHttpClient.initSuccess()) {

            try {
                sIHttpClient.before(requestMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sIHttpClient.asyncRequest(requestMsg, responseListener, tag);
            try {
                sIHttpClient.after(requestMsg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public static void cancelAll(RequestQueue.RequestFilter filter) {

        sIHttpClient.cancelAll(filter);
    }


    public static void cancelAll(Object tag) {

        sIHttpClient.cancelAll(tag);
    }

    public static void stop() {
        sIHttpClient.stop();
    }
}
