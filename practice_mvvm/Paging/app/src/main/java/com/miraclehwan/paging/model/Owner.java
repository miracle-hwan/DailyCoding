package com.miraclehwan.paging.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("reputation")
    @Expose
    public int reputation;
    @SerializedName("user_id")
    @Expose
    public long userId;
    @SerializedName("user_type")
    @Expose
    public String userType;
    @SerializedName("profile_image")
    @Expose
    public String profileImage;
    @SerializedName("display_name")
    @Expose
    public String displayName;
    @SerializedName("link")
    @Expose
    public String link;
    @SerializedName("accept_rate")
    @Expose
    public long acceptRate;
}
