package com.example.mypagingboundarycb.ikds;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

import com.example.mypagingboundarycb.api.RetrofitClient;
import com.example.mypagingboundarycb.db.MyDataBase;
import com.example.mypagingboundarycb.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonBoundaryCallBack extends PagedList.BoundaryCallback<Person> {

    private Application application;
    public static final int PER_PAGE = 10;

    public PersonBoundaryCallBack(Application application){
        this.application = application;
    }


    /**
     * 加载第一页
     */
    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        getTopData();
    }

    private void getTopData() {
        int since = 0;
        RetrofitClient.getInstance()
                .getApi()
                .getPagesIKDS(since,PER_PAGE)
                .enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body());
                            //把数据传递给PagedList
                            insertPerson(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {

                    }
                });
    }

    /**
     * 把网络数据缓存到数据库
     * @param body
     */
    private void insertPerson(List<Person> body) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MyDataBase.getInstance(application).getPersonDao()
                        .insertPerson(body);
            }
        });
    }

    /**
     * 加载第二页
     * @param person
     */
    @Override
    public void onItemAtEndLoaded(@NonNull Person person) {
        super.onItemAtEndLoaded(person);
        getTopAfterData(person);
    }

    private void getTopAfterData(Person person) {
        RetrofitClient.getInstance()
                .getApi()
                .getPagesIKDS(person.id,PER_PAGE)
                .enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body());
                            //把数据传递给PagedList
                            insertPerson(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {

                    }
                });
    }
}
