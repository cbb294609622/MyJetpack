package com.example.mypagingboundarycb;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mypagingboundarycb.ikds.PersonPagedListAdapter;
import com.example.mypagingboundarycb.ikds.PersonViewModel;
import com.example.mypagingboundarycb.model.Person;

public class TestActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swiper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        swiper = findViewById(R.id.swiper);
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

        swiper.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                viewModel.refresh();
                swiper.setRefreshing(false);
            }
        });

    }
}
