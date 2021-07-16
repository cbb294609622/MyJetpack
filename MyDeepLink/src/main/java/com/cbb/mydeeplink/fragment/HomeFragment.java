package com.cbb.mydeeplink.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cbb.mydeeplink.R;


public class HomeFragment extends Fragment {


    private int notificationID;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btn = getView().findViewById(R.id.button);
        //lambda表达式
        btn.setOnClickListener((v)->{
            sendNotification();
        });
    }

    private void sendNotification() {
        //通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(getActivity().
                    getPackageName(), "MyChannel", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("My NotificationChannel");
            NotificationManager manager = getActivity().
                    getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        Notification notification = new NotificationCompat.Builder(getActivity(),
                getActivity().getPackageName())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Deep Link")
                .setContentText("点击我跳转。。。。")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(getPendingIntent())
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat
                .from(getActivity());
        notificationManagerCompat.notify(notificationID++,notification);
    }

    private PendingIntent getPendingIntent() {
        Bundle args = new Bundle();
        args.putString("name","jack");
        return Navigation.findNavController(getActivity(),R.id.button)
                .createDeepLink()
                .setGraph(R.navigation.my_nav)
                .setDestination(R.id.detailFragment)
                .setArguments(args)
                .createPendingIntent();
    }
}