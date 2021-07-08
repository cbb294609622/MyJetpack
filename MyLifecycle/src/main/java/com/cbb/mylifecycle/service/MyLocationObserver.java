package com.cbb.mylifecycle.service;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationObserver implements LifecycleObserver {

    private Context mContext;
    private LocationManager mLocation;
    private MyLocationListener myLocationListener;

    public MyLocationObserver(Context mContext) {
        this.mContext = mContext;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void startLocation() {
        Log.e("chen", "startLocation");
        mLocation = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        myLocationListener = new MyLocationListener();
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 1, myLocationListener);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void stopLocation(){
        Log.e("chen", "stopLocation");
        mLocation.removeUpdates(myLocationListener);
    }

    static class MyLocationListener implements LocationListener{

        @Override
        public void onLocationChanged(@NonNull Location location) {
            Log.e("chen", "onLocationChanged:"+location.toString());
        }
    }

}
