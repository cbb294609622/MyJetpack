package com.cbb.mydatabinding.examples4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ActivityFourBinding;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFourBinding fourBinding = DataBindingUtil.setContentView(this, R.layout.activity_four);
        fourBinding.setUserViewModel(new UserViewModel());
    }
}
