package com.hopefound.testdemo.Base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.hopefound.testdemo.gen.GreenDaoManager;

/**
 * Created by 王震 on 2018/4/25 0025.
 */

public class BaseApplication extends Application{
    public static String id;
    public static String classid = "4";
    public static String name;
    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
//        Hawk.init(this).build();
//        RongIM.init(this);
//        ToastsUtils.register(this);
        instance = this;
        GreenDaoManager.getIstance();

    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return 进程号
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
