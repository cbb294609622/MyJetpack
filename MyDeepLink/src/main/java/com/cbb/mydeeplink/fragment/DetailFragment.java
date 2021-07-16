package com.cbb.mydeeplink.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cbb.mydeeplink.R;


public class DetailFragment extends Fragment {


    private static final String TAG = DetailFragment.class.getSimpleName();

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btn = getView().findViewById(R.id.button2);

        String name = getArguments().getString("name");
        Log.e(TAG, "onActivityCreated: "+name);

        String params = getArguments().getString("params");
        Log.e(TAG, "onActivityCreated: "+params);


        //lambda表达式
        btn.setOnClickListener((v)->{
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}