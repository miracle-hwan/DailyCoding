package com.miraclehwan.myworkmanager;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName = "miraclework_timeline")
public class Work {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "time")
    private String time;

    public Work() {
        this.time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    @NonNull
    public String getTime() {
        return time;
    }

    public void setTime(@NonNull String time) {
        this.time = time;
    }
}
