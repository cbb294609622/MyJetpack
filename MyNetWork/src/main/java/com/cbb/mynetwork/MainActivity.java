package com.cbb.mynetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.cbb.mynetwork.network.NetWorkChangeReceiver;

public class MainActivity extends AppCompatActivity implements NetWorkChangeReceiver.NetStateChangeObserver{

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetWorkChangeReceiver.registerObserver(this,this);
    }

    @Override
    public void onDisconnect() {
        Log.e(TAG, "onDisconnect: 网络丢失了");
    }

    @Override
    public void onMobileConnect() {
        Log.e(TAG, "onMobileConnect: 手机联网成功了");
    }

    @Override
    public void onWifiConnect() {
        Log.e(TAG, "onWifiConnect: WIFI联网成功了");
    }

    @Override
    public void onNetworkConnect() {
        Log.e(TAG, "onNetworkConnect: 手机或WIFI联网成功了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetWorkChangeReceiver.unRegisterObserver(this,this);
    }
}