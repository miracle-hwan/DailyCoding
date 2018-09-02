package com.miraclehwan.paging.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;
import android.util.Log;

import com.miraclehwan.paging.model.Item;
import com.miraclehwan.paging.model.ItemDataSource;
import com.miraclehwan.paging.model.ItemDataSourceFactory;

public class ItemViewModel extends ViewModel{

    public LiveData<PagedList<Item>> itemPagedList;
    public LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE).build();

        LivePagedListBuilder livePagedListBuilder= (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig));
        itemPagedList = livePagedListBuilder.build();
    }
}