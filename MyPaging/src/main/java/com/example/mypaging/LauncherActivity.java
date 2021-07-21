package com.example.mypaging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void btn1(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void btn2(View view) {

        startActivity(new Intent(this,HomeActivity.class));
    }

    public void btn3(View view) {

        startActivity(new Intent(this,TestActivity.class));
    }
}
