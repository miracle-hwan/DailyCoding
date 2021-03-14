package com.miraclehwan.paging.test

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.miraclehwan.paging.test.Api
import com.miraclehwan.paging.test.response.Data

class PostDataSource() : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = Api.instance.getListDataLegacy(currentLoadingPageKey)
            val responseData = mutableListOf<Data>()
            val data = response.body()?.dataList ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            Log.e("daehwan", "${responseData.size}")
            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            Log.e("daehwan", "${e.message}")
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }
}