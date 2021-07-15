package com.cbb.mynavigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.cbb.mynavigation.R;

public class HomeFragment extends Fragment {


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

//        默认传参方式
//            Bundle args = new Bundle();
//            args.putString("user_name","jack");
//            NavController navController = Navigation.findNavController(v);
//            navController.navigate(R.id.action_homeFragment_to_detailFragment,args);

            //第二种
            Bundle bundle = new HomeFragmentArgs.Builder()
                    .setUserName("jack")
                    .setAge(22)
                    .build().toBundle();
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle);

        });
    }
}