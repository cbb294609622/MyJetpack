package com.cbb.mydatabinding.examples3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cbb.mydatabinding.R;
import com.cbb.mydatabinding.databinding.ActivityTestBinding;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTestBinding testBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        testBinding.setNetworkImage("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_360_360%2Fbb%2F37%2Ff5%2Fbb37f583e8da88aed385306a07361c2a.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628648831&t=0d45d6376945b6a98240f23801332fcf");
//        testBinding.setLocalImage(R.mipmap.ic_launcher);
    }
}
