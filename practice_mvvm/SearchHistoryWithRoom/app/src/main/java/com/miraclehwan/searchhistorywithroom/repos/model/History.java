package com.miraclehwan.searchhistorywithroom.repos.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName = "search_table")
public class History {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "content")
    private String content;

    @NonNull
    @ColumnInfo(name = "date")
    private String date;

    public History(@NonNull String content) {
        this.content = content;
        this.date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }
}