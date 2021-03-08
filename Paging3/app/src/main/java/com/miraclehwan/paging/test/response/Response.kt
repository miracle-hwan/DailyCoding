package com.miraclehwan.paging.test.response


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("data")
    val dataList: List<Data> = emptyList(),
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: Support,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)