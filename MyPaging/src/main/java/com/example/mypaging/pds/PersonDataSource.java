package com.example.mypaging.pds;

import android.util.Log;

import androidx.paging.PositionalDataSource;

import com.example.mypaging.api.RetrofitClient;
import com.example.mypaging.model.Pages;
import com.example.mypaging.model.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDataSource extends PositionalDataSource<Person> {

    public static final int PER_PAGE = 8;

    //页面首次加载数据的时候
    @Override
    public void loadInitial(PositionalDataSource.LoadInitialParams params, PositionalDataSource.LoadInitialCallback<Person> callback) {
        int startPosition = 0;

        RetrofitClient.getInstance()
                .getApi()
                .getPages(startPosition,PER_PAGE)
                .enqueue(new Callback<Pages>() {
                    @Override
                    public void onResponse(Call<Pages> call, Response<Pages> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body().personList);
                            //把数据传递给PagedList
                            callback.onResult(response.body().personList,
                                    startPosition,
                                    response.body().total);

                        }
                    }

                    @Override
                    public void onFailure(Call<Pages> call, Throwable t) {

                    }
                });
    }
    //加载第N次的时候  下一页
    @Override
    public void loadRange(PositionalDataSource.LoadRangeParams params, PositionalDataSource.LoadRangeCallback<Person> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getPages(params.startPosition,PER_PAGE)
                .enqueue(new Callback<Pages>() {
                    @Override
                    public void onResponse(Call<Pages> call, Response<Pages> response) {
                        if (response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body().personList);
                            Log.e("chen", "loadRange: "+response.body().personList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Pages> call, Throwable t) {

                    }
                });
    }
}
