package com.cbb.myworkmanager;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {


    private static final String TAG = MyWork.class.getSimpleName();

    public MyWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
//        SystemClock.sleep(2000);
        Log.e(TAG, "doWork: MyWork");
        return Result.success();
    }
}
