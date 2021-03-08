package com.miraclehwan.paging.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("answer_id")
    val answerId: Int,
    @SerializedName("content_license")
    val contentLicense: String,
    @SerializedName("creation_date")
    val creationDate: Int,
    @SerializedName("is_accepted")
    val isAccepted: Boolean,
    @SerializedName("last_activity_date")
    val lastActivityDate: Int,
    @SerializedName("last_edit_date")
    val lastEditDate: Int,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("question_id")
    val questionId: Int,
    @SerializedName("score")
    val score: Int
)