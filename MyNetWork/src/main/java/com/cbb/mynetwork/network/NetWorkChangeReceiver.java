package com.cbb.mynetwork.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import java.util.ArrayList;
import java.util.List;

public class NetWorkChangeReceiver extends BroadcastReceiver {

    private List<NetStateChangeObserver> mObservers = new ArrayList<>();
    private int mType = -1;
    private static boolean isRegister = false;

    private static class InstanceHolder {
        private static final NetWorkChangeReceiver INSTANCE = new NetWorkChangeReceiver();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            int connectivityStatus = NetWorkUtils.getConnectivityStatus(context);
            notifyObservers(connectivityStatus);
        }
    }

    public static void registerReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(InstanceHolder.INSTANCE, intentFilter);
        isRegister = true;
    }

    public static void unRegisterReceiver(Context context) {
        if (isRegister) {
            context.unregisterReceiver(InstanceHolder.INSTANCE);
        }
    }

    public static void registerObserver(NetStateChangeObserver observer,Context mContext) {
        if (observer == null) {
            return;
        }
        registerReceiver(mContext);
        if (!InstanceHolder.INSTANCE.mObservers.contains(observer)) {
            InstanceHolder.INSTANCE.mObservers.add(observer);
        }
    }

    public static void unRegisterObserver(NetStateChangeObserver observer,Context mContext) {
        if (observer == null) {
            return;
        }
        if (InstanceHolder.INSTANCE.mObservers == null) {
            return;
        }
        InstanceHolder.INSTANCE.mObservers.remove(observer);
        unRegisterReceiver(mContext);
    }

    private void notifyObservers(int networkType) {
        if (mType == networkType) {
            return;
        }
        mType = networkType;
        if (networkType == NetWorkUtils.TYPE_MOBILE) {
            for (NetStateChangeObserver observer : mObservers) {
                observer.onMobileConnect();
                observer.onNetworkConnect();
            }
        } else if (networkType == NetWorkUtils.TYPE_WIFI) {
            for (NetStateChangeObserver observer : mObservers) {
                observer.onWifiConnect();
                observer.onNetworkConnect();
            }
        } else {
            for (NetStateChangeObserver observer : mObservers) {
                observer.onDisconnect();
            }
        }
    }

    public interface NetStateChangeObserver {

        void onDisconnect();

        void onMobileConnect();

        void onWifiConnect();

        void onNetworkConnect();
    }
}
