package com.miraclehwan.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class StackExchangeViewModel : ViewModel() {

    val itemList = Pager(PagingConfig(pageSize = 20)) {
        StackExchangeDataSource()
    }.flow.cachedIn(viewModelScope)
}