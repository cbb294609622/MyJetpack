package com.example.mypaging.api;

import com.example.mypaging.model.Pages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("paging/dps")
    Call<Pages> getPages(
            @Query("start") int page,
            @Query("count") int count
    );

}