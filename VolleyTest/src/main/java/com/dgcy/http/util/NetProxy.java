package com.dgcy.http.util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.apache.http.HttpHost;

public class NetProxy {

    public static HttpHost getProxy(Context context) {
        HttpHost proxy = null;
        // 判断Wap网络并设置代理
        NetType netType = getNetType(context);
        if (netType != null && netType.isWap()) {
            proxy = new HttpHost(netType.getProxy(), netType.getPort());
        }
        return proxy;
    }

    /**
     * 判断当前网络状态是否可用
     *
     * @param context
     * @return
     */
    public static boolean getNetworkState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        if (info != null) {
            return true;
        }

        return false;
    }

    /**
     * 判断网络类型
     *
     * @param context
     * @return
     */
    public static NetType getNetType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null)
            return null;

        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info == null)
            return null;

        String type = info.getTypeName();

        if (type.equalsIgnoreCase("WIFI")) {
            // WIFI方式
            return null;
        } else if (type.equalsIgnoreCase("MOBILE")) {
            // GPRS方式
            String proxyHost = android.net.Proxy.getDefaultHost();
            if (proxyHost != null && !proxyHost.equals("")) {
                // WAP方式
                NetType netType = new NetType();
                netType.setProxy(proxyHost);
                netType.setPort(android.net.Proxy.getDefaultPort());
                netType.setWap(true);
                return netType;
            }
        }
        return null;
    }

    public static class NetType {
        private String apn = "";
        private String proxy = "";
        private String typeName = "";
        private int port = 0;
        private boolean isWap = false;

        public String getApn() {
            return apn;
        }

        public void setApn(String apn) {
            this.apn = apn;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getProxy() {
            return proxy;
        }

        public void setProxy(String proxy) {
            this.proxy = proxy;
        }

        public boolean isWap() {
            return isWap;
        }

        public void setWap(boolean isWap) {
            this.isWap = isWap;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }
}
