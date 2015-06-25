package com.cy.zd.serial.port;

import java.util.EventObject;

/**
 * 串口调用返回事件类
 * @author Eric
 */
public class SerialPortEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private Object dataText;//事件源

    public SerialPortEvent(Object dataText){
        super(dataText);
        this.dataText = dataText;
    }
    /**
     * 获取返回数据
     * @return
     */
    public Object getDataText() {
        return dataText;
    }
    /**
     * 设置返回
     * @param dataText
     */
    public void setDataText(Object dataText) {
        this.dataText = dataText;
    }
}
