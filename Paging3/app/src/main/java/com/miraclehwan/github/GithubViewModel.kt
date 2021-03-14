package com.miraclehwan.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.rxjava2.cachedIn
import androidx.paging.rxjava2.observable

class GithubViewModel : ViewModel() {
    val itemList = Pager(PagingConfig(pageSize = 20)) {
        GithubDataSource()
    }.flow
// add header, footer, seaprator
//        .map {
//        it.map<Item> { Item(it) }.insertHeaderItem(Item("HEADER"))
//            .insertFooterItem(Item("FOOTER")).insertSeparators { before, after ->
//            when {
//                before is Item && after is Item -> {
//                    if (before.title.startsWith("C") && after.title.startsWith("A")) Item else null
//                }
//                else -> null
//            }
//        }
//    }
        .cachedIn(viewModelScope)

    val itemObservable = Pager(PagingConfig(pageSize = 20)) {
        GithubRxDataSource()
    }.observable.cachedIn(viewModelScope)
}