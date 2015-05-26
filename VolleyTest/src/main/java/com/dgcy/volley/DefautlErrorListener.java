package com.dgcy.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.dgcy.http.base.IResponseListener;
import com.dgcy.http.util.HttpLog;

/**
 * Created by zf on 2015/5/11.
 */
public class DefautlErrorListener<T> implements Response.ErrorListener {

    private static final String TAG = DefautlErrorListener.class.getName();
    private IResponseListener<T> mIResponseListener;

    public DefautlErrorListener(IResponseListener<T> IResponseListener) {
        mIResponseListener = IResponseListener;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        try {
            HttpLog.warn(TAG, "Get Error Msg From Server : " + error.getMessage()
                    + " ; NetWorkTime : " + error.getNetworkTimeMs());

            if (error instanceof NetworkError) {
            } else if (error instanceof ParseError) {
            } else if (error instanceof ServerError) {
            } else if (error instanceof AuthFailureError) {
            } else if (error instanceof ParseError) {
            } else if (error instanceof NoConnectionError) {
            } else if (error instanceof TimeoutError) {
            }

            if (mIResponseListener != null) {
                mIResponseListener.onExecuteFailure();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
