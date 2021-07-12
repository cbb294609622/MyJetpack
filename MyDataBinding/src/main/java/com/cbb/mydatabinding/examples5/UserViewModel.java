package com.cbb.mydatabinding.examples5;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.cbb.mydatabinding.BR;

public class UserViewModel{
    private ObservableField<User> userObservableField;
    public UserViewModel(){
        User user = new User("Jack");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);
    }

    public String getUserName(){
        return userObservableField.get().userName;
    }

    public void setUserName(String name){
        Log.e("ex5", "setUserName:"+name);
        userObservableField.get().userName = name;
    }

}
