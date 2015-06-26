package com.yasenagat.code;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TK on 2015/6/5.
 */


public class PrimaryGenerater {

     private static final int MAX_VALUE=9999;
     private static final String FORMAT = "yyyyMMddHHmmssSS";
     private static final Format DF= new SimpleDateFormat(FORMAT);
     private static final byte[] lock = new byte[0];
     private String prefix = null;
     private Date date = null;
     private int number=1;
     private static Map<String, PrimaryGenerater> map = new HashMap<String, PrimaryGenerater>();

     private PrimaryGenerater(String prefix,Date date){
         this.prefix = prefix;
         this.date = date;
     }

     public static PrimaryGenerater newInstance(String prefix){
         Date date = new Date();
         return newInstance(prefix,date);
     }

     public static PrimaryGenerater newInstance(String prefix,Date date){
         PrimaryGenerater o = null;
         synchronized (lock) {
             String key = getKey(prefix, date);
             if(map.containsKey(key)){
                 o = map.get(key);
                 int number = o.getNumber();
                 if(number<MAX_VALUE){
                     o.setNumber(number+1);
                 }else {
                     o.setNumber(1);
                 }

             } else {
                 o = new PrimaryGenerater(prefix,date);
                 map.put(key, o);
             }
         }
         return o;
     }


    public static String getID(){
        int r1=(int)(Math.random()*(90000))+10000;//产生2个0-9的随机数
        int r2=(int)(Math.random()*(90000))+10000;
        long now = System.currentTimeMillis();//一个13位的时间戳
        String paymentID ="0003"+String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
        return paymentID;

    }

     private static String getKey(String prefix,Date date){
         return prefix+format(date);
     }

     private static String format(Date date){
         return DF.format(date);
     }

     public String toString(){
         return  prefix+ format(date) + String.format("%04d", number);
     }

     public void setNumber(int number) {
         this.number = number;
     }

     public int getNumber() {
         return number;
     }
}