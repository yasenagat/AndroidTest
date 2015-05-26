package com.dgcy.http.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zf on 2015/3/24.
 */
public class CacheCfg {

    private static final Set<String> cacheSet = new HashSet<String>();

    static {
//        cacheSet.add("LTY1002");
//        cacheSet.add("LTY1003");
//        cacheSet.add("LTY4000");
//        cacheSet.add("LTY9000");
//        cacheSet.add("ACT1001");
//        cacheSet.add("LTY3000");
//        cacheSet.add("INF1000");
//        cacheSet.add("INF1001");
//        cacheSet.add("LTY1103");
//        cacheSet.add("LTY1105");
//        cacheSet.add("LTY1102");
//        cacheSet.add("LTY1108");

    }

    public static boolean isCache(String cmd) {
        return cacheSet.contains(cmd);
    }

    private static final Map<String, Long> cacheExpireTime = new HashMap<String, Long>();

    private static final long second = 1000;
    private static final long minmute = second * 60;
    private static final long hour = minmute * 60;

    private static final long defautlExpireTime = second * 30;

    public static final long delTime = hour * 24;

    static {
//        cacheExpireTime.put("LTY1002", minmute);
//        cacheExpireTime.put("LTY1003", minmute);
//        cacheExpireTime.put("LTY4000", minmute);
//        cacheExpireTime.put("LTY9000", minmute * 5);
//        cacheExpireTime.put("ACT1001", minmute);
//        cacheExpireTime.put("LTY3000", minmute);
//        cacheExpireTime.put("INF1000", minmute * 5);
//        cacheExpireTime.put("INF1001", minmute * 5);
//        cacheExpireTime.put("LTY1103", minmute * 5);
//        cacheExpireTime.put("LTY1105", minmute * 2);
//        cacheExpireTime.put("LTY1102", minmute * 1);
//        cacheExpireTime.put("LTY1108", minmute * 1);
    }

    public static long getExpireTime(String cmd) {
        if (isCache(cmd)) {
            return cacheExpireTime.get(cmd) == null ? defautlExpireTime : cacheExpireTime.get(cmd);
        }
        return 0;
    }
}
