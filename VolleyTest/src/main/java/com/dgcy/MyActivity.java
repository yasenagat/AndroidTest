package com.dgcy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.dgcy.client.HttpClientFactory;
import com.dgcy.http.base.DefaultJsonResponseListener;
import com.dgcy.http.msg.INF1000_Req;
import com.dgcy.http.msg.LTY1100_Req;
import com.dgcy.http.msg.LTY1100_Res;
import com.dgcy.http.msg.LTY3000_Req;
import com.dgcy.http.msg.LTY3000_Res;
import com.dgcy.http.util.HttpLog;
import com.dgcy.volley.BitmapCache;


public class MyActivity extends Activity {

    private String TAG = "MyActivity";

    private Button button2;
    private ImageView imageView;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        HttpClientFactory.init(MyActivity.this);
        button2 = (Button) this.findViewById(R.id.button2);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        button3 = (Button) this.findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Log.d(TAG, "click");
//                                           Request.Method.GET, "http://172.16.198.53/json"
//                                           RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
                                           LTY3000_Req req = new LTY3000_Req();
                                           req.setReq_Body(new LTY3000_Req.LTY3000_Req_Body("", new INF1000_Req.INF1000_Req_Body.QueryFilter("", "SSQ")));

                                           try {

                                               HttpClientFactory.asyncRequest(req, new DefaultJsonResponseListener<LTY3000_Res>() {

                                                   @Override
                                                   public void onSuccess(LTY3000_Res lty1000_res) {
//                                                       Log.d(TAG, responseData);
                                                       Log.d(TAG, lty1000_res.decodeBody());
                                                   }


                                               }, TAG);
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           }

//                                           mQueue.add(new RocketRequest<LTY1000_Res>(req, new DefaultJsonResponseListener<LTY1000_Res>() {
//                                               @Override
//                                               public void onSuccess(String responseData, Class<LTY1000_Res> clazz) {
//
//                                                   LTY1000_Res res = getResponse(responseData, clazz);
//
//                                                   Log.d(TAG, responseData);
//                                                   Log.d(TAG, res.decodeBody());
//                                               }
//
//                                               @Override
//                                               public void onFailure() {
//
//                                               }
//
//                                               @Override
//                                               public void onFinish() {
//
//                                               }
//                                           }));
//                                           mQueue.add(new StringRequest(Request.Method.GET, "http://172.16.198.53/json", new Response.Listener<String>() {
//                                               @Override
//                                               public void onResponse(String response) {
//                                                   Log.d(TAG, "response" + response);
//                                               }
//                                           }, null));


//                                           mQueue.start();
//                                           mQueue.cancelAll(this);
                                       }
                                   }

        );

        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        ImageLoader mImageLoader = new ImageLoader(mQueue, new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
        Log.d(TAG, "mImageLoader : " + mImageLoader);
        mImageLoader.get("http://e.hiphotos.baidu.com/image/w%3D400/", listener);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

//                        while (true) {
//                            try {
//                                Thread.sleep(1500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                            LTY1100_Req req = new LTY1100_Req();
                            req.setReq_Body(new LTY1100_Req.LTY1100_Req_Body("SSQ", ""));

                            try {
                                HttpClientFactory.asyncRequest(req, new DefaultJsonResponseListener<LTY1100_Res>() {
                                    @Override
                                    public void onSuccess(LTY1100_Res lty1100_res) {
                                        HttpLog.debug(TAG, lty1100_res.decodeBody());
                                    }
                                }, TAG);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

//                    }
                }).start();


            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        HttpClientFactory.cancelAll(TAG);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        HttpClientFactory.cancelAll(TAG);
        HttpClientFactory.stop();
    }
}
