package com.example.mypagingboundarycb.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mypagingboundarycb.model.Person;


@Database(entities = {Person.class},version = 1,exportSchema = true)
public abstract class MyDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db.db";

    private static MyDataBase instance;

    public static synchronized MyDataBase getInstance(Context mContext){
        if (instance == null){
            instance = Room.databaseBuilder(
                    mContext.getApplicationContext(),
                    MyDataBase.class,
                    DATABASE_NAME).build();
        }
        return instance;
    }

    public abstract PersonDao getPersonDao();

}
