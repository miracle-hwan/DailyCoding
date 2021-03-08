package com.miraclehwan.paging.response


import com.google.gson.annotations.SerializedName

data class AnswerResponse(
    @SerializedName("backoff")
    val backoff: Int,
    @SerializedName("has_more")
    val hasMore: Boolean,
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("quota_max")
    val quotaMax: Int,
    @SerializedName("quota_remaining")
    val quotaRemaining: Int
)