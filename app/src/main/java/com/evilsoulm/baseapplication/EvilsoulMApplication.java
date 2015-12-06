package com.evilsoulm.baseapplication;

import android.app.Application;
import android.content.res.Configuration;

import com.evilsoulm.application.BaseApplication;
import com.evilsoulm.baseapplication.app.MainProcessApplication;
import com.evilsoulm.baseapplication.app.SecondProcessApplication;
import com.evilsoulm.baseapplication.utils.Utils;

/**
 * Author by mazixuan
 * Data:2015-12-06 14:51
 * Project:BaseApplication
 * Detail:
 */
public class EvilsoulMApplication extends Application {
    private BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        if (Utils.isMainProcess(this)) {
            baseApplication = new MainProcessApplication(this);
        } else {//如果不止两个进程当然可以再细分
            baseApplication = new SecondProcessApplication(this);
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (baseApplication != null) {
            baseApplication.onTerminate();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (baseApplication != null) {
            baseApplication.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (baseApplication != null) {
            baseApplication.onLowMemory();
        }
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (baseApplication != null) {
            baseApplication.onTrimMemory(level);
        }
    }


}
