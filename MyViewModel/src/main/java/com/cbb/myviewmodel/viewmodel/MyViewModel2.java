package com.cbb.myviewmodel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class MyViewModel2 extends AndroidViewModel {
    public int number;

    public MyViewModel2(@NonNull @org.jetbrains.annotations.NotNull Application application) {
        super(application);
    }
}
