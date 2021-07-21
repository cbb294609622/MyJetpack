package com.example.mypaging.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pages {

    //positionDataSource 固有字段
    public int start;//当前页
    public int count;//数量
    public int total;//多少条


    //PageKeyDataSource固有字段
    public boolean hasMore;


    //公共字段
    @SerializedName("data")
    public List<Person> personList;

    @Override
    public String toString() {
        return "Pages{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", hasMore=" + hasMore +
                ", personList=" + personList +
                '}';
    }
}
