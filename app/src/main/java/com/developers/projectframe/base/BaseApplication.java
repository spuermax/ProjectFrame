package com.developers.projectframe.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * @Author yinzh
 * @Date 2020/3/21 10:13
 * @Description
 */
public class BaseApplication extends MultiDexApplication {
    private static Context mAppContext;
    public static BaseApplication baseApp;

    public String host;
    //token
    public String token;
    //加密用
    public String domain;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = getApplicationContext();
        baseApp = this;
    }

    public static BaseApplication getBaseApp() {
        return baseApp;
    }
}
