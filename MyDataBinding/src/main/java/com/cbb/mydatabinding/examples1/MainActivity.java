package com.cbb.mydatabinding.examples1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.bean.Idol;
import com.cbb.mydatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mAMB = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mAMB.setIdol(new Idol("刘亦菲",2));
        mAMB.setEventHandler(new EventHandlerListener(this));
    }
}