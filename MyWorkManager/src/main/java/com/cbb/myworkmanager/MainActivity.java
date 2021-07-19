package com.cbb.myworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mAddWork(View view) {
        //设置触发条件
        Constraints constraints = new Constraints.Builder()
                //.setRequiredNetworkType (NetworkType. CONNECTED) //网络连接时执行
                //.setRequiresBatteryNotLow(true) //不在电量不足执行
                //.setRequiresCharging(true) //在充电时执行
                //.setRequiresStorageNotLow(true) //不在存储容量不足时执行
                //.setRequiresDeviceIdle(true) //在待机状态 下执行调用需要API级别最低为23

                //NetworkType.NOT_REQUIRED:对网络没有要求
                //NetworkType.CONNECTED:网络连接的时候执行
                //NetworkType.UNMETERED:不计费的网络比如WIFI下执行
                //NetworkType.NOT_ROAMING:非漫游网络状态
                //NetworkType.METERED:计费网络比如3G、4G下执行
                //注意：不代表恢复网络了，就立即执行。
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();


        //配置任务
        //一次性执行的任务
        OneTimeWorkRequest request1 = new OneTimeWorkRequest.Builder(MyWork.class)
                //设置触发条件
                .setConstraints(constraints)
                //设置延迟执行
                .setInitialDelay(5, TimeUnit.SECONDS)
                .build();

        //将任务提交给WorkManager
        WorkManager manager = WorkManager.getInstance(this);
        manager.enqueue(request1);
    }
}