package com.cbb.myworkmanager;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork extends Worker {


    private static final String TAG = MyWork.class.getSimpleName();

    public MyWork(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        String input_data = getInputData().getString("input_data");
//        SystemClock.sleep(2000);
        Log.e(TAG, "doWork: MyWork  ,inputdata:"+input_data);

        //任务执行完之后返回数据
        Data data = new Data.Builder()
                .putString("output_data", "执行完成")
                .build();
        return Result.success(data);
    }
}
