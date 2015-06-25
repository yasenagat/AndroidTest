package com.cy.zd.serial.port;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 串口事件处理
 *
 * @author Eric
 */
public class SerialPortEventObject {
	private String dataText;
	/**
	 * 监听器容器
	 */
	private Set<SerialPortEventListener> listener;

	public SerialPortEventObject() {
		this.listener = new HashSet<SerialPortEventListener>();
		this.dataText = "";
	}

	/**
	 * 给事件源注册监听器
	 *
	 * @param cel
	 */
	public void addCusListener(SerialPortEventListener cel) {
		this.listener.add(cel);
	}

	/**
	 * 当事件发生时,通知注册在该事件源上的所有监听器做出相应的反应（调用回调方法）
	 */
	protected void showDataText() {
		SerialPortEventListener cel = null;
		Iterator<SerialPortEventListener> iterator = this.listener.iterator();
		while (iterator.hasNext()) {
			cel = iterator.next();
			cel.fireCusEvent(new SerialPortEvent(this));
		}
	}

	/**
	 * 获取数据
	 *
	 * @return
	 */
	public String getDataText() {
		return dataText;
	}

	/**
	 * 事件触发器
	 *
	 * @param dataText
	 */
	public void setDataText(String dataText) {
		this.dataText = dataText;
		showDataText();
	}
}