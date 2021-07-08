package com.cbb.mylifecycle.app;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //针对整个应用程序的监听，与activity数量无关
        ProcessLifecycleOwner.get().getLifecycle()
                .addObserver(new ApplicationObserver());
    }
}
