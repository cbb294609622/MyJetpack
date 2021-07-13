package com.cbb.myrooms;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Student> students;
    private StudentRecyclerViewAdapter studentRecyclerViewAdapter;
    private StudentViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView = findViewById(R.id.recyclerview);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        students = new ArrayList<>();
        studentRecyclerViewAdapter = new StudentRecyclerViewAdapter(students);
        recycleView.setAdapter(studentRecyclerViewAdapter);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(StudentViewModel.class);
        viewModel.getAllStudentsLive().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentRecyclerViewAdapter.setStudents(students);
                studentRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    public void mAdd(View view) {
        Student s1 = new Student("JACK",20);
        Student s2 = new Student("ROSE",21);
        viewModel.insertStudent(s1,s2);
    }

    public void mUpdate(View view) {
        Student s1 = new Student(1,"JACKr",222);
        viewModel.updateStudent(s1);
    }

    public void mDel(View view) {
        Student s1 = new Student(2);
        viewModel.deleteStudent(s1);
    }

    public void mClear(View view) {
        viewModel.deleteAllStudent();
    }
}