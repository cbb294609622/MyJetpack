package com.cbb.myworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class DWorker extends Worker {


    private static final String TAG = DWorker.class.getSimpleName();

    public DWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        Log.e(TAG, "doWork: "+this.getClass().getSimpleName());
        return Result.success();
    }
}
