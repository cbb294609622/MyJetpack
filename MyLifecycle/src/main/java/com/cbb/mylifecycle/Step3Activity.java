package com.cbb.mylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cbb.mylifecycle.service.MyLocationService;

public class Step3Activity extends AppCompatActivity {

    //adb -s emulator-5554 emu geo fix 121.4961236714487 31.24010934431376
    //adb -s emulator-5554 emu geo fix 122.4961236714487 31.24010934431376

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

    }

    public void startGps(View view) {
        startService(new Intent(this, MyLocationService.class));
    }

    public void closeGps(View view) {
        stopService(new Intent(this, MyLocationService.class));
    }
}
