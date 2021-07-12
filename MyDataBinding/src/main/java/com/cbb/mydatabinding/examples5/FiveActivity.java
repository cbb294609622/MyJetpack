package com.cbb.mydatabinding.examples5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ActivityFiveBinding;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFiveBinding fiveBinding = DataBindingUtil.setContentView(this, R.layout.activity_five);
        fiveBinding.setUserViewModel(new UserViewModel());
    }
}
