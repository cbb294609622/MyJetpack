package com.cbb.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cbb.myviewmodel.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private MyViewModel myViewModel;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = findViewById(R.id.tv);
        myViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        mTv.setText(String.valueOf(++myViewModel.number));
//        mTv.setText(String.valueOf(number));
    }

    public void Add(View view) {
        mTv.setText(String.valueOf(++myViewModel.number));
//        mTv.setText(String.valueOf(++number));
    }
}