package com.cbb.mydatabinding.examples2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.bean.Idol;
import com.cbb.mydatabinding.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        dataBinding.setIdol(new Idol("刘亦菲",2));
    }
}
