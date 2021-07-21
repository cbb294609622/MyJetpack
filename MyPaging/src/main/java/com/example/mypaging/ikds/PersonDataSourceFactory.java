package com.example.mypaging.ikds;

import androidx.paging.DataSource;

import com.example.mypaging.model.Person;


public class PersonDataSourceFactory extends DataSource.Factory<Integer, Person>{


    @Override
    public DataSource<Integer, Person> create() {
        return new PersonDataSource();
    }
}
