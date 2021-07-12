package com.cbb.myroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db.db";

    private static MyDataBase mInstance;

    /**
     * 不能加入私有的构造方法，因为MyDataBase是抽象方法，
     * 并且RoomDatabase是会调用MyDataBase的构造函数。
     */
//    private MyDataBase(){}

    public static synchronized MyDataBase getInstance(Context mContext){
        if (mInstance == null){
            mInstance = Room.databaseBuilder(mContext.getApplicationContext(),
                    MyDataBase.class,
                    DATABASE_NAME)
//                    .allowMainThreadQueries() //可以在主线程操作数据库
                    .build();
        }
        return mInstance;
    }

    public abstract StudentDao getStudentDao();

}
