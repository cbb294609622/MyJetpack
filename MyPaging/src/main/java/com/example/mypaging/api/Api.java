package com.example.mypaging.api;


import com.example.mypaging.model.Pages;
import com.example.mypaging.model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("paging/dps")
    Call<Pages> getPages(
            @Query("start") int page,
            @Query("count") int count
    );

    @GET("paging/pkds")
    Call<Pages> getPagesPKDS(
            @Query("page") int page,
            @Query("pageSize") int count
    );

    @GET("paging/ikds")
    Call<List<Person>> getPagesIKDS(
            @Query("since") int since,
            @Query("pageSize") int pageSize
    );

}
