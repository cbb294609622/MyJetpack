package com.cbb.mydatabinding.examples4;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.cbb.mydatabinding.BR;

public class UserViewModel extends BaseObservable {
    private User user;
    public UserViewModel(){
        this.user = new User("JACK");
    }

    @Bindable
    public String getUserName(){
        return user.userName;
    }

    public void setUserName(String name){
        if (name != null && !name.equals(user.userName)){
            this.user.userName = name;
            Log.e("ex4", "set name :"+user.userName);
            notifyPropertyChanged(BR.userName);
        }
    }
}
