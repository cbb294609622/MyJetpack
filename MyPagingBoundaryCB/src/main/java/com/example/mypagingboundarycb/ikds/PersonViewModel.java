package com.example.mypagingboundarycb.ikds;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.mypagingboundarycb.R;
import com.example.mypagingboundarycb.db.MyDataBase;
import com.example.mypagingboundarycb.db.PersonDao;
import com.example.mypagingboundarycb.model.Person;


public class PersonViewModel extends AndroidViewModel {
    private static final int PAGE_SIZE = 8;
    public LiveData<PagedList<Person>> pagedListLiveData;

    public PersonViewModel(@NonNull Application application) {
        super(application);
        PersonDao dao = MyDataBase.getInstance(application).getPersonDao();
        pagedListLiveData = new LivePagedListBuilder<>(
            dao.getPersonList(),PAGE_SIZE)
                .setBoundaryCallback(new PersonBoundaryCallBack(application))
                .build();
    }

    /**
     * 刷新数据
     */
    public void refresh(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MyDataBase.getInstance(getApplication()).getPersonDao().clear();
            }
        });
    }

}
