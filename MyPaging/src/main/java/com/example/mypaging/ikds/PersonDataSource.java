package com.example.mypaging.ikds;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.mypaging.api.RetrofitClient;
import com.example.mypaging.model.Pages;
import com.example.mypaging.model.Person;

import java.util.IllegalFormatCodePointException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDataSource extends ItemKeyedDataSource<Integer, Person> {

    public static final int PER_PAGE = 10;


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Person> callback) {
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
                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Person> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getPagesIKDS(params.key,PER_PAGE)
                .enqueue(new Callback<List<Person>>() {
                    @Override
                    public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body());
                            //把数据传递给PagedList
                            callback.onResult(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Person>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Person> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Person item) {
        return item.id;
    }
}
