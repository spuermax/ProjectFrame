package com.developers.projectframe;

import com.developers.projectframe.base.BaseApplication;

/**
 * @Author yinzh
 * @Date 2020/3/22 09:58
 * @Description
 */
public class ProjectApplication extends BaseApplication {
    public static ProjectApplication app;
    private static final String TAG = "EdusohoApp";

    @Override
    public void onCreate() {
        super.onCreate();
        app =this;
    }
}
