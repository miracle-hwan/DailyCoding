package com.miraclehwan.paging.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("owner")
    @Expose
    public Owner owner;
    @SerializedName("is_accepted")
    @Expose
    public boolean isAccepted;
    @SerializedName("score")
    @Expose
    public long score;
    @SerializedName("last_activity_date")
    @Expose
    public long lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    public long creationDate;
    @SerializedName("answer_id")
    @Expose
    public long answerId;
    @SerializedName("question_id")
    @Expose
    public long questionId;
    @SerializedName("last_edit_date")
    @Expose
    public long lastEditDate;
}
