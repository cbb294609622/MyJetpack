package com.example.mypaging.ikds;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.mypaging.model.Person;


public class PersonViewModel extends ViewModel {
    public LiveData<PagedList<Person>> pagedListLiveData;
    public PersonViewModel(){
        PagedList.Config config = new PagedList.Config.Builder()
                //设置控件占位
                .setEnablePlaceholders(false)
                .setPageSize(PersonDataSource.PER_PAGE)
                //当距离底部还有多少条数据时，开始加载下一页
                .setPrefetchDistance(2)
                //设置首次加载的数量
                .setInitialLoadSizeHint(PersonDataSource.PER_PAGE)
                .setMaxSize(65536 * PersonDataSource.PER_PAGE)
                .build();
        pagedListLiveData = new LivePagedListBuilder<>(new PersonDataSourceFactory(),config)
                .build();
    }
}
