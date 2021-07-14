package com.cbb.myrooms;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;

    @ColumnInfo(name = "name",typeAffinity = ColumnInfo.TEXT)
    public String name;

    @ColumnInfo(name = "age",typeAffinity = ColumnInfo.INTEGER)
    public int age;

    @ColumnInfo(name = "sex",typeAffinity = ColumnInfo.INTEGER)
    public int sex;

    @ColumnInfo(name = "bar_data",typeAffinity = ColumnInfo.INTEGER)
    public int barData;

    @Ignore
    public boolean isIgnore;//忽略字段 不存储

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Ignore
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Ignore
    public Student(int id) {
        this.id = id;
    }
}
