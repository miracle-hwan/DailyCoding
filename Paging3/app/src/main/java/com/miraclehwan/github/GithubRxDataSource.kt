package com.miraclehwan.github

import androidx.paging.PagingState
import androidx.paging.rxjava2.RxPagingSource
import com.miraclehwan.github.response.Item
import io.reactivex.Single

class GithubRxDataSource : RxPagingSource<Int, Item>() {

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, Item>> {
        val currentPageKey = params.key ?: 1
        val prevKey = if (currentPageKey == 1) null else currentPageKey - 1
        return GithubApi.instance.getRxRepos(currentPageKey)
            .map<LoadResult<Int, Item>> { res ->
                val itemList = mutableListOf<Item>()
                val data = res.items ?: emptyList()
                itemList.addAll(data)

                LoadResult.Page(
                    data = itemList,
                    prevKey = prevKey,
                    nextKey = currentPageKey + 1
                )
            }
            .onErrorReturn { LoadResult.Error(it) }
    }

    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition
    }
}