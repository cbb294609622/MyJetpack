package com.example.mypaging.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pages {
    public int start;//当前页
    public int count;//数量
    public int total;//多少条

    @SerializedName("data")
    public List<Person> personList;

    @Override
    public String toString() {
        return "Pages{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", personList=" + personList +
                '}';
    }
}
