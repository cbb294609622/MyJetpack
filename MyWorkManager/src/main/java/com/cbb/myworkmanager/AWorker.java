package com.cbb.myworkmanager;

import android.content.Context;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class AWorker extends Worker {


    private static final String TAG = AWorker.class.getSimpleName();

    public AWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        Log.e(TAG, "doWork: "+this.getClass().getSimpleName());
        return Result.success();
    }
}
