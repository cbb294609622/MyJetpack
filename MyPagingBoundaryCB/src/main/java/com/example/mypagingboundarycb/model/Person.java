package com.example.mypagingboundarycb.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


@Entity(tableName = "Person")
public class Person {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no",typeAffinity = ColumnInfo.INTEGER)
    public int NO;

    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    public int id;
    @ColumnInfo(name = "name",typeAffinity = ColumnInfo.TEXT)
    public String name;
    @ColumnInfo(name = "sex",typeAffinity = ColumnInfo.TEXT)
    public String sex;
    @ColumnInfo(name = "age",typeAffinity = ColumnInfo.INTEGER)
    public int age;
    @ColumnInfo(name = "url",typeAffinity = ColumnInfo.TEXT)
    public String url;

    @Override
    public String toString() {
        return "Person{" +
                "NO=" + NO +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return NO == person.NO &&
                id == person.id &&
                age == person.age &&
                name.equals(person.name) &&
                sex.equals(person.sex) &&
                url.equals(person.url);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(NO, id, name, sex, age, url);
    }
}
