package com.cbb.myrooms.task;

import android.os.AsyncTask;

import com.cbb.myrooms.Student;
import com.cbb.myrooms.StudentDao;


public class DeleteAllStudentTask extends AsyncTask<Void,Void,Void> {

    private StudentDao studentDao;

    public DeleteAllStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Void... Void) {
        studentDao.deleteAllStudent();
        return null;
    }
}