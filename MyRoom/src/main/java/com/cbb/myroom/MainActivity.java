package com.cbb.myroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.cbb.myroom.task.DeleteStudentTask;
import com.cbb.myroom.task.GetAllStudentTask;
import com.cbb.myroom.task.InsertStudentTask;
import com.cbb.myroom.task.UpdateStudentTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> students;
    private StudentRecyclerViewAdapter studentRecyclerViewAdapter;
    private StudentDao stuDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView = findViewById(R.id.recyclerview);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        students = new ArrayList<>();
        studentRecyclerViewAdapter = new StudentRecyclerViewAdapter(students);
        recycleView.setAdapter(studentRecyclerViewAdapter);
        MyDataBase dataBase = MyDataBase.getInstance(this);
        stuDao = dataBase.getStudentDao();
    }

    public void mAdd(View view) {
        Student s1 = new Student("JACK",20);
        Student s2 = new Student("JACK",20);
        Student s3 = new Student("JACK",20);
        Student s4 = new Student("JACK",20);
        new InsertStudentTask(stuDao).execute(s1,s2,s3,s4);
    }

    public void mFind(View view) {
        new GetAllStudentTask(stuDao,studentRecyclerViewAdapter).execute();
    }

    public void mUpdate(View view) {
        Student s1 = new Student(1,"JACKr",222);
        new UpdateStudentTask(stuDao).execute(s1);
    }

    public void mDel(View view) {
        Student s1 = new Student(2);
        new DeleteStudentTask(stuDao).execute(s1);
    }
}