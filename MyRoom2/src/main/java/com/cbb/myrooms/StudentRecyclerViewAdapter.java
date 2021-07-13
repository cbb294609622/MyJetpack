package com.cbb.myrooms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentRecyclerViewAdapter extends RecyclerView.Adapter<StudentRecyclerViewAdapter.MyViewHolder> {

    List<Student> mList;

    public StudentRecyclerViewAdapter(List<Student> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = mList.get(position);
        holder.mID.setText(String.valueOf(student.id));
        holder.mName.setText(String.valueOf(student.name));
        holder.mAge.setText(String.valueOf(student.age));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setStudents(List<Student> students){
        this.mList = students;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mID;
        private TextView mName;
        private TextView mAge;
        public MyViewHolder(View view) {
            super(view);
            mID = view.findViewById(R.id.id);
            mName = view.findViewById(R.id.name);
            mAge = view.findViewById(R.id.age);
        }
    }
}
