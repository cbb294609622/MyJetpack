package com.cbb.myroom.task;

import android.os.AsyncTask;

import com.cbb.myroom.Student;
import com.cbb.myroom.StudentDao;

public class UpdateStudentTask extends AsyncTask<Student,Void,Void> {

    private StudentDao studentDao;

    public UpdateStudentTask(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Student... students) {
        studentDao.updateStudent(students);
        return null;
    }
}