package com.example.mypagingboundarycb.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Person {
    public int id;
    public String name;
    public String sex;
    public int age;
    public String url;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
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
        return id == person.id &&
                age == person.age &&
                name.equals(person.name) &&
                sex.equals(person.sex) &&
                url.equals(person.url);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, url);
    }
}
