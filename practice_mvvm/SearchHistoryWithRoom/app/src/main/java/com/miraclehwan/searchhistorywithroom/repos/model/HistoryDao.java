package com.miraclehwan.searchhistorywithroom.repos.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface HistoryDao {

    @Query("SELECT * FROM search_table ORDER BY date DESC LIMIT 20")
    LiveData<List<History>> getHistoryList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History history);

    @Query("DELETE FROM search_table WHERE content = :content")
    void deleteItem(String content);

    @Query("DELETE FROM search_table")
    void deleteAll();
}
