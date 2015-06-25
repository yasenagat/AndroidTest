package com.cy.zd.serial.port;

import java.util.EventListener;

/**
 * 串口调用事件监听器，实现java.util.EventListener接口。定义回调方法，将你想要做的事
 * 放到这个方法下,因为事件源发生相应的事件时会调用这个方法。
 * @author Eric
 */
public class SerialPortEventListener implements EventListener {

    //事件发生后的回调方法
    public void fireCusEvent(SerialPortEvent e){
//        SerialPortEventObject eObject = (SerialPortEventObject)e.getDataText();
//        System.out.println("I got a new name,named \""+eObject.getDataText()+"\"");
    }
}
