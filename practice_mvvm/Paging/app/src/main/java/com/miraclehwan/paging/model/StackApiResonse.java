package com.miraclehwan.paging.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StackApiResonse {
    @SerializedName("items")
    @Expose
    public List<Item> items = null;
    @SerializedName("has_more")
    @Expose
    public boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    public int quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    public int quotaRemaining;
}
