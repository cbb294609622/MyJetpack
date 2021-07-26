package com.example.mypagingboundarycb.pkds;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.mypagingboundarycb.api.RetrofitClient;
import com.example.mypagingboundarycb.model.Pages;
import com.example.mypagingboundarycb.model.Person;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonDataSource extends PageKeyedDataSource<Integer, Person> {

    public static final int PER_PAGE = 10;
    public static final int FIRST_PAGE = 1;

    /**
     * 首次加载
     * @param params
     * @param callback
     */
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Person> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getPagesPKDS(FIRST_PAGE,PER_PAGE)
                .enqueue(new Callback<Pages>() {
                    @Override
                    public void onResponse(Call<Pages> call, Response<Pages> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body().personList);
                            //把数据传递给PagedList
                            callback.onResult(response.body().personList,null,FIRST_PAGE+1);

                        }
                    }

                    @Override
                    public void onFailure(Call<Pages> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Person> callback) {

    }

    /**
     * 下一页
     * @param params
     * @param callback
     */
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Person> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getPagesPKDS(params.key,PER_PAGE)
                .enqueue(new Callback<Pages>() {
                    @Override
                    public void onResponse(Call<Pages> call, Response<Pages> response) {
                        if (response.body() != null){
                            Log.e("chen", "loadInitial: "+response.body().personList);
                            Integer nextKey = response.body().hasMore ? params.key +1 : null;
                            //把数据传递给PagedList
                            callback.onResult(response.body().personList,nextKey);

                        }
                    }

                    @Override
                    public void onFailure(Call<Pages> call, Throwable t) {

                    }
                });
    }
}
