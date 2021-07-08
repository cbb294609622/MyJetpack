package com.cbb.mylifecycle;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class Step1Activity extends AppCompatActivity {

    private Chronometer mChronometer;
    private long elapsedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChronometer = findViewById(R.id.chronometer);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mChronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        mChronometer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        elapsedTime = SystemClock.elapsedRealtime() - mChronometer.getBase();
        mChronometer.stop();
    }
}
