package com.miraclehwan.github

import android.util.Log
import androidx.paging.PagingSource
import com.miraclehwan.github.response.Item

class GithubDataSource : PagingSource<Int, Item>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        try {
            val currentPageKey = params.key ?: 1
            val prevKey = if (currentPageKey == 1) null else currentPageKey - 1

            val response = GithubApi.instance.getRepos(
                currentPageKey
            )

            if (response.code() != 200) {
                return LoadResult.Page(
                    data = mutableListOf(),
                    prevKey = prevKey,
                    nextKey = null
                )
            }

            val itemList = mutableListOf<Item>()
            val data = response.body()?.items ?: emptyList()
            itemList.addAll(data)

            return LoadResult.Page(
                data = itemList,
                prevKey = prevKey,
                nextKey = currentPageKey + 1
            )
        } catch (e: Exception) {
            Log.e("daehwan", "${e.message}")
            return LoadResult.Error(e)
        }
    }
}