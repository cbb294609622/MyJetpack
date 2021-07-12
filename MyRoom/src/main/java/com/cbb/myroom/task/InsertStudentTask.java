package com.cbb.myroom.task;

import android.os.AsyncTask;

import com.cbb.myroom.Student;
import com.cbb.myroom.StudentDao;

public class InsertStudentTask  extends AsyncTask<Student,Void,Void> {

    private StudentDao studentDao;

    public InsertStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Student... students) {
        studentDao.insertStudent(students);
        return null;
    }
}