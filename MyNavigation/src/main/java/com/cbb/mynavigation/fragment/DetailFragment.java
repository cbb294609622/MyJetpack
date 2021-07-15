package com.cbb.mynavigation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cbb.mynavigation.R;

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

//        默认传参方式
//        String user_name = getArguments().getString("user_name");
//        Log.e(TAG, "onActivityCreated: "+user_name);

        //第二种
        HomeFragmentArgs args = HomeFragmentArgs.fromBundle(getArguments());
        Log.e(TAG, "onActivityCreated: "+args.getUserName()+","+args.getAge());

        //lambda表达式
        btn.setOnClickListener((v)->{
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_detailFragment_to_homeFragment);
        });
    }
}