package com.cbb.myrooms;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.cbb.myrooms.task.DeleteAllStudentTask;
import com.cbb.myrooms.task.DeleteStudentTask;
import com.cbb.myrooms.task.InsertStudentTask;
import com.cbb.myrooms.task.UpdateStudentTask;

import java.util.List;

public class StudentRepository {

    private StudentDao studentDao;

    public StudentRepository(Context mContext) {
        MyDataBase dataBase = MyDataBase.getInstance(mContext);
        this.studentDao = dataBase.getStudentDao();
    }

    public void insertStudent(Student... students){
        new InsertStudentTask(studentDao).execute(students);
    }

    public void updateStudent(Student... students){
        new UpdateStudentTask(studentDao).execute(students);
    }
    public void deleteStudent(Student... students){
        new DeleteStudentTask(studentDao).execute(students);
    }

    public void deleteAllStudent(){
        new DeleteAllStudentTask(studentDao).execute();
    }

    public LiveData<List<Student>> findAllStudentsLive(){
        return studentDao.getAllStudentsLive();
    }
}
