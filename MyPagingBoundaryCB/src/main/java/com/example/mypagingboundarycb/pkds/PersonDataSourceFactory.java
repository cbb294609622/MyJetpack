package com.example.mypagingboundarycb.pkds;

import androidx.paging.DataSource;

import com.example.mypagingboundarycb.model.Person;


public class PersonDataSourceFactory extends DataSource.Factory<Integer, Person>{


    @Override
    public DataSource<Integer, Person> create() {
        return new PersonDataSource();
    }
}
