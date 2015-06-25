package com.cy.zd.serial;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.cy.zd.serial.port.SerialPort;
import com.cy.zd.serial.port.SerialPortEvent;
import com.cy.zd.serial.port.SerialPortEventListener;
import com.cy.zd.serial.port.SerialPortEventObject;
import com.yasenagat.R;


public class MainActivity extends Activity {
    private WebView show;
    private Handler handler;
    public EditText showLog;
    public EditText sendData;
    public EditText comPort;
    private final String TAG = "SerialPort";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.showLog = (EditText)findViewById(R.id.et_logs );
        this.showLog.getText().append("日志\n");
        this.sendData = (EditText)findViewById(R.id.et_data );
        this.comPort = (EditText)findViewById(R.id.et_com );


        //注册监听器(返回数据)
        SerialPort.getSerialPort().addCusListener(new SerialPortEventListener() {
            @Override
            public void fireCusEvent(SerialPortEvent e) {
                super.fireCusEvent(e);
//	                showText.getText().append(e.getSource().toString()+"\n");
                SerialPortEventObject eObject = (SerialPortEventObject) e.getDataText();
//                System.out.println("+++++++++++++"+eObject.getDataText());
//                backData = eObject.getDataText();
                Message msg = new Message();
                msg.what = 0x1111;
                msg.obj = eObject;
                handler.sendMessage(msg);
            }
        });

        this.handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x1111) {
//                    Log.i(TAG, "测试回调");
                    SerialPortEventObject eObject = (SerialPortEventObject)msg.obj;
                    showLog.getText().append( eObject.getDataText()+"\n");
                }

                super.handleMessage(msg);
            }
        };
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * 打开
     * @param view
     */
    public void btn_open_Click(View view)
    {
        //dialog(view);
        String msg = SerialPort.getSerialPort().init(this.comPort.getText().toString(),5);
        this.showLog.getText().append(msg+"\n");
    }

    /**
     * 关闭
     * @param view
     */
    public void btn_close_Click(View view)
    {
        //dialog(view);
        String msg = SerialPort.getSerialPort().stop();
        this.showLog.getText().append(msg+"\n");
    }


    /**
     * 读取数据
     * @param view
     */
    public void btn_read_Click(View view)
    {
        //dialog(view);
        String msg = SerialPort.getSerialPort().read();
        this.showLog.getText().append(msg+"\n");
    }

    /**
     * 清空数据
     * @param view
     */
    public void btn_clear_Click(View view)
    {
        this.showLog.getText().clear();
    }

    /**
     * 读取数据
     * @param view
     */
    public void btn_send_Click(View view)
    {
        //dialog(view);
        String msg = this.sendData.getText().toString();
        if(msg.length()!=16){
            dialog(view,"数据必须为16位！！！");
            return;
        }
        String result = SerialPort.getSerialPort().send(msg);
        this.showLog.getText().append("写入数据："+result+"\n");
    }

    /**
     * 信息提示
     * @param view
     */
    protected void dialog(View view,String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage(msg);
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                Main.this.finish();
            }
        });
        builder.create().show();
    }

    /**
     * 信息提示
     * @param view
     */
    protected void dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setMessage("确认退出吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                Main.this.finish();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
