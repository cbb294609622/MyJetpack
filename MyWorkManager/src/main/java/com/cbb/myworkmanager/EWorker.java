package com.cbb.myworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class EWorker extends Worker {


    private static final String TAG = EWorker.class.getSimpleName();

    public EWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        Log.e(TAG, "doWork: "+this.getClass().getSimpleName());
        return Result.success();
    }
}
