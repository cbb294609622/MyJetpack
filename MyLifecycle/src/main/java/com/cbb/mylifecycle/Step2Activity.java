package com.cbb.mylifecycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Step2Activity extends AppCompatActivity {

    private MyChronometer mChronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mChronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(mChronometer);
    }

}
