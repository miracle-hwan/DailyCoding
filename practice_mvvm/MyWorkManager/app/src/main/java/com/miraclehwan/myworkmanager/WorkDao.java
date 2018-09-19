package com.miraclehwan.myworkmanager;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WorkDao {

    @Query("SELECT * FROM miraclework_timeline ORDER BY time DESC")
    LiveData<List<Work>> getWorkList();

    @Insert
    void insert(Work time);
}
