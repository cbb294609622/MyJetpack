package com.cbb.myrooms;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Student.class},version = 3,exportSchema = true)
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
                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                    .build();
        }
        return mInstance;
    }


    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT 1");
        }
    };
    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN bar_data INTEGER NOT NULL DEFAULT 1");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            //1.创建临时表
            database.execSQL("CREATE TABLE temp_student (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                    "name TEXT,"+
                    "age INTEGER NOT NULL,"+
                    "sex TEXT DEFAULT 'M',"+    //integer 修改为Text类型
                    "bar_data INTEGER NOT NULL DEFAULT 1)");
            //2.复制数据到临时表
            database.execSQL("INSERT INTO temp_student (name,age,sex,bar_data)"+
                    "SELECT name,age,sex,bar_data FROM student ");
            //3.删除原始表
            database.execSQL("DROP TABLE student");
            //4.修改临时表为正式表
            database.execSQL("ALTER TABLE temp_student RENAME TO student");
        }
    };

    public abstract StudentDao getStudentDao();

}
