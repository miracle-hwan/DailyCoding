package com.miraclehwan.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

class GithubViewModel : ViewModel() {
    val itemList = Pager(PagingConfig(pageSize = 20)) {
        GithubDataSource()
    }.flow.cachedIn(viewModelScope)
}