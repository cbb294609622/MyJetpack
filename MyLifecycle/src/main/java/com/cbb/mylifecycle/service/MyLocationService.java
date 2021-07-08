package com.cbb.mylifecycle.service;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

/**
 * LifeCycle的好处
 *
 * 1.帮组开发者建立可感知生命周期的组件
 * 2.组件在其内部管理自己的生命周期，从而降低模块耦合度
 * 3.降低内存泄漏发声的可能性
 * 4.Activity Fragment Service Application均有LifeCycle的支持
 */
public class MyLocationService extends LifecycleService {

    public MyLocationService() {
        Log.e("chen", "MyLocationService");
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);

    }
}
