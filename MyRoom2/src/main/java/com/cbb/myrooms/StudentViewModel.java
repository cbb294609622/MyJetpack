package com.cbb.myrooms;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {


    private StudentRepository repository;

    public StudentViewModel(Application application) {
        super(application);
        this.repository = new StudentRepository(application);
    }

    public void insertStudent(Student... students){
        repository.insertStudent(students);
    }
    public void deleteStudent(Student... students){
        repository.deleteStudent(students);
    }
    public void deleteAllStudent(){
        repository.deleteAllStudent();
    }
    public void updateStudent(Student... students){
        repository.updateStudent(students);
    }
    public LiveData<List<Student>> getAllStudentsLive(){
        return repository.findAllStudentsLive();
    }
}
