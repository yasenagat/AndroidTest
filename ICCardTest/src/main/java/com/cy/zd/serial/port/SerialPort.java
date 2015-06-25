package com.cy.zd.serial.port;

import android.util.Log;

public class SerialPort {
	/**
	 * 返回数据事件
	 */
	public SerialPortEventObject object = new SerialPortEventObject();
	private static SerialPort sp;
	public  SerialPort(){
	}

	/**
	 * 获取对象
	 * @return
	 */
	public final static SerialPort getSerialPort(){
		if(sp==null){
			sp=new SerialPort();
		}
		return sp;
	}

	//日志标题
	private static final String TAG = "SerialPort";
	/**
	 * 启动
	 * @param com
	 * @return
	 */

	public String init(String com,int timeout) {
		String str = doInit(com,timeout);
		Log.i(SerialPort.TAG,str);

		return str;
	}
	/**
	 * 返回数据
	 * @param data
	 */
	public void backData(String data){
		Log.i(SerialPort.TAG,"显示java中数据");
		Log.i(SerialPort.TAG, data);
//		ma.showLog(data);
		this.object.setDataText(data);
	}


	/**
	 * 关闭
	 * @return
	 */
	public String stop(){
		return doStop();
	}
	/**
	 * 读取
	 * @return
	 */
	public String read(){
		return doRead();
	}
	/**
	 * 发送
	 * @param str
	 * @return
	 */
	public String send(String str){
		String data =doSend(str);
		Log.i(SerialPort.TAG,"显示java中数据");
		Log.i(SerialPort.TAG,data);
		return data;
	}

	/**
	 * 设置查询超时
	 * @param timeout
	 * @return
	 */
	public String setTimeoutParam(int timeout){
		return this.doTimeoutParam(timeout);
	}

	/**
	 * 添加监听
	 * @param listener
	 */
	public void addCusListener(SerialPortEventListener listener){
		this.object.addCusListener(listener);
	}



	static
	{
		System.loadLibrary("SerialPort");
	}
	/**
	 * 启动
	 * @param port
	 * @return
	 */
	private native String doInit(String port,int timeout);
	/**
	 * 关闭
	 * @return
	 */
	private native String doStop();
	/**
	 * 发送
	 * @param inputStr
	 * @return
	 */
	private native String doSend(String inputStr);
	/**
	 * 接收数据
	 * @return
	 */
	private native String doRead();

	/**
	 * 读取超时设置
	 * @param timeout
	 * @return
	 */
	private native String doTimeoutParam(int timeout);

}
