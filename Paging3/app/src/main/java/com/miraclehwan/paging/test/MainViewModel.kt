package com.miraclehwan.paging.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class MainViewModel : ViewModel() {

//    val listData = Pager(PagingConfig(pageSize = 6)) {
//        PostDataSource()
//    }.observable.cachedIn(viewModelScope)

    val listData = Pager(PagingConfig(pageSize = 2)) {
        PostDataSource()
    }.flow.cachedIn(viewModelScope)
}