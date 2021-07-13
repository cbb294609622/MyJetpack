package com.cbb.myrooms.task;

import android.os.AsyncTask;

import com.cbb.myrooms.Student;
import com.cbb.myrooms.StudentDao;

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