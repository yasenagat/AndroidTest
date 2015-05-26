package com.y;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.Properties;

import butterknife.ButterKnife;

public class SimpleApp extends Application {

    protected static SimpleApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        ButterKnife.setDebug(BuildConfig.DEBUG);
        instance = this;
        Thread.setDefaultUncaughtExceptionHandler(restartHandler); // 程序崩溃时触发线程  以下用来捕获程序崩溃异常

    }

    // 创建服务用于捕获崩溃异常
    private Thread.UncaughtExceptionHandler restartHandler = new Thread.UncaughtExceptionHandler() {
        /**
         * Debug Log Tag
         */
        public static final String TAG = "CrashHandler";
        /**
         * 是否开启日志输出, 在Debug状态下开启, 在Release状态下关闭以提升程序性能
         */
        public static final boolean DEBUG = true;


        private Properties mDeviceCrashInfo = new Properties();

        private static final String VERSION_NAME = "versionName";
        private static final String VERSION_CODE = "versionCode";
        private static final String STACK_TRACE = "STACK_TRACE";

        public void uncaughtException(Thread thread, Throwable ex) {
            ex.printStackTrace();

            collectCrashDeviceInfo(getApplicationContext());
            getCrashInfo(ex);
            restartApp();//发生崩溃异常时,重启应用
        }

        public void collectCrashDeviceInfo(Context ctx) {
            try {
                // Class for retrieving various kinds of information related to the
                // application packages that are currently installed on the device.
                // You can find this class through getPackageManager().
                PackageManager pm = ctx.getPackageManager();
                // getPackageInfo(String packageName, int flags)
                // Retrieve overall information about an application package that is
                // installed on the system.
                // public static final int GET_ACTIVITIES
                // Since: API Level 1 PackageInfo flag: return information about
                // activities in the package in activities.
                PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(),
                        PackageManager.GET_ACTIVITIES);
                if (pi != null) {
                    // public String versionName The version name of this package,
                    // as specified by the <manifest> tag's versionName attribute.
                    mDeviceCrashInfo.put(VERSION_NAME,
                            pi.versionName == null ? "not set" : pi.versionName);
                    // public int versionCode The version number of this package,
                    // as specified by the <manifest> tag's versionCode attribute.
                    mDeviceCrashInfo.put(VERSION_CODE, pi.versionCode);
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(TAG, "Error while collect package info", e);
            }
            // 使用反射来收集设备信息.在Build类中包含各种设备信息,
            // 例如: 系统版本号,设备生产商 等帮助调试程序的有用信息
            // 返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段
            Field[] fields = Build.class.getDeclaredFields();
            for (Field field : fields) {
                try {
                    // setAccessible(boolean flag)
                    // 将此对象的 accessible 标志设置为指示的布尔值。
                    // 通过设置Accessible属性为true,才能对私有变量进行访问，不然会得到一个IllegalAccessException的异常
                    field.setAccessible(true);
                    mDeviceCrashInfo.put(field.getName(), field.get(null));
                    if (DEBUG) {
                        Log.d(TAG, field.getName() + " : " + field.get(null));
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error while collect crash info", e);
                }
            }
        }

        private void getCrashInfo(Throwable ex) {
            Writer info = new StringWriter();
            PrintWriter printWriter = new PrintWriter(info);
            // printStackTrace(PrintWriter s)
            // 将此 throwable 及其追踪输出到指定的 PrintWriter
            ex.printStackTrace(printWriter);

            // getCause() 返回此 throwable 的 cause；如果 cause 不存在或未知，则返回 null。
            Throwable cause = ex.getCause();
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }

            // toString() 以字符串的形式返回该缓冲区的当前值。
            String result = info.toString();
            printWriter.close();
            mDeviceCrashInfo.put(STACK_TRACE, result);
        }
    };

    public void restartApp() {
        Intent intent = new Intent(instance, SimpleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        instance.startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());  //结束进程之前可以把你程序的注销或者退出代码放在这段代码之前
    }
}
