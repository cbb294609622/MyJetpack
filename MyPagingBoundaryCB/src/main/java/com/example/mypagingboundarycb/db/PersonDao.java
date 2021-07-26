package com.example.mypagingboundarycb.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mypagingboundarycb.model.Person;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertPerson(List<Person> persons);

    @Query("DELETE FROM person")
    void clear();

    @Query("SELECT * FROM person")
    DataSource.Factory<Integer,Person> getPersonList();
}

