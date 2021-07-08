package com.cbb.mylivedata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.cbb.mylivedata.examples1.MainActivity;
import com.cbb.mylivedata.examples2.HomeActivity;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }

    public void btnTimer(View view) {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    public void btnFragment(View view) {
        startActivity(new Intent(this, HomeActivity.class));
        this.finish();
    }
}
