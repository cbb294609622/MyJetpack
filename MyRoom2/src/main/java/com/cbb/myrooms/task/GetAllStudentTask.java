package com.cbb.myrooms.task;

import android.os.AsyncTask;


import com.cbb.myrooms.Student;
import com.cbb.myrooms.StudentDao;
import com.cbb.myrooms.StudentRecyclerViewAdapter;

import java.util.List;

public class GetAllStudentTask extends AsyncTask<Void,Void,Void> {

    private StudentDao studentDao;
    private StudentRecyclerViewAdapter mAdapter;

    public GetAllStudentTask(StudentDao studentDao,StudentRecyclerViewAdapter mAdapter) {
        this.studentDao = studentDao;
        this.mAdapter = mAdapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        List<Student> stus = studentDao.getAllStudent();
        mAdapter.setStudents(stus);
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        mAdapter.notifyDataSetChanged();
    }
}