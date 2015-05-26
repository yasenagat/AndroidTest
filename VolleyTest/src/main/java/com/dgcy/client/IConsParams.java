package com.dgcy.client;

import java.util.HashMap;

/**
 * Created by zf on 2015/5/11.
 */
public class IConsParams {
    public static final String DATA_MODULE_1 = "1";
    public static final String DATA_MODULE_2 = "2";
    public static final String DATA_MODULE_3 = "3";
    public static final String DATA_MODULE_4 = "4";

    private static final String PRODUCT_URL = "http://app.zgxmcp.com:10002/client";

    public static String URL = PRODUCT_URL;
    public static final String SLASH = "/";
    public static String productId = "cp_android_sd_fc";
    public static String channelId = "default";
    public static String sKey;
    public static String sId;
    public static String productVersion;
    public static String deviceId;
    //test
//    private static final String key = "3A3132333435363738393B3132333435";
//    private static final String keyId = "APP201503160001";
//    product
    public static final String key = "3A4164333D52363747593B613C5348560";
    public static final String keyId = "APP20150428001";


    /**
     * Server ResultCode↓↓*
     */
    public static final String RESULTCODE_SUCCESS = "0";
    public static final String RESULTCODE_ERROR = "-1";
    public static final String RESULTCODE_ENCODE_ERROR = "-2";
    public static final String RESULTCODE_REQUEST_PARAM_ERROE = "-3";
    public static final String RESULTCODE_SYSTEM_MAINTENANCE = "-4";
    public static final String RESULTCODE_SERVER_BUSY = "-5";
    public static final String RESULTCODE_LOGIN_TIMEOUT = "-6";

    public static final HashMap<String, String> MAP_RESULTCODE = new HashMap<String, String>();

    static {
        MAP_RESULTCODE.put(RESULTCODE_SUCCESS, "");
        MAP_RESULTCODE.put(RESULTCODE_ERROR, "服务器异常");
        MAP_RESULTCODE.put(RESULTCODE_ENCODE_ERROR, "数据加密错误");
        MAP_RESULTCODE.put(RESULTCODE_REQUEST_PARAM_ERROE, "请求参数无效");
        MAP_RESULTCODE.put(RESULTCODE_SYSTEM_MAINTENANCE, "系统维护中");
        MAP_RESULTCODE.put(RESULTCODE_SERVER_BUSY, "服务器忙，稍后重试");
        MAP_RESULTCODE.put(RESULTCODE_LOGIN_TIMEOUT, "登录超时,请先登录");
    }
    /**Server ResultCode↑↑**/
}
