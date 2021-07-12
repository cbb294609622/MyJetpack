package com.cbb.mydatabinding.examples7;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ActivitySevenBinding;

public class SevenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySevenBinding sevenBinding = DataBindingUtil.setContentView(this,R.layout.activity_seven);

        MyViewModel myViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        sevenBinding.setViewModel(myViewModel);
        sevenBinding.setLifecycleOwner(this);
    }
}
