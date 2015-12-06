package com.evilsoulm.baseapplication.app;

import android.app.Application;

import com.evilsoulm.application.BaseApplication;

/**
 * Author by mazixuan
 * Data:2015-12-06 14:55
 * Project:BaseApplication
 * Detail:主进程实例
 */
public class MainProcessApplication extends BaseApplication {

    public MainProcessApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        //初始化主进程需要的东西
//        getApplication().registerComponentCallbacks(this);  可以直接拿到application实例
    }
}
