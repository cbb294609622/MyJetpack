package com.cbb.myworkmanager;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkManager 任务链
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mAddWork(View view) {

        OneTimeWorkRequest buildA = new OneTimeWorkRequest.Builder(AWorker.class).build();
        OneTimeWorkRequest buildB = new OneTimeWorkRequest.Builder(BWorker.class).build();
        OneTimeWorkRequest buildC = new OneTimeWorkRequest.Builder(CWorker.class).build();
        OneTimeWorkRequest buildD = new OneTimeWorkRequest.Builder(DWorker.class).build();
        OneTimeWorkRequest buildE = new OneTimeWorkRequest.Builder(EWorker.class).build();

        //顺序执行
        /*WorkManager.getInstance(this)
                .beginWith(buildA)
                .then(buildB)
                .enqueue();*/

        //任务组合
        WorkContinuation workContinuation1 = WorkManager.getInstance(this)
                .beginWith(buildA)
                .then(buildB);
        WorkContinuation workContinuation2 = WorkManager.getInstance(this)
                .beginWith(buildC)
                .then(buildD);

        List<WorkContinuation> taskList = new ArrayList<>();
        taskList.add(workContinuation1);
        taskList.add(workContinuation2);

        WorkContinuation.combine(taskList)
                .then(buildE)
                .enqueue();

    }
}
