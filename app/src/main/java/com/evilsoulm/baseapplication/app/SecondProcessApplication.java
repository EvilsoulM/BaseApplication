package com.evilsoulm.baseapplication.app;

import android.app.Application;

import com.evilsoulm.application.BaseApplication;

/**
 * Author by mazixuan
 * Data:2015-12-06 14:56
 * Project:BaseApplication
 * Detail:子进程实例
 */
public class SecondProcessApplication extends BaseApplication {
    public SecondProcessApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        //初始化子进程所需要的东西
    }
}
