package com.example.mypaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.mypaging.model.Person;
import com.example.mypaging.paging.PersonPagedListAdapter;
import com.example.mypaging.paging.PersonViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PersonPagedListAdapter adapter = new PersonPagedListAdapter(this);
        recyclerView.setAdapter(adapter);

        PersonViewModel viewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(PersonViewModel.class);
        viewModel.pagedListLiveData.observe(this, new Observer<PagedList<Person>>() {
            @Override
            public void onChanged(PagedList<Person> people) {
                adapter.submitList(people);
            }
        });
    }
}