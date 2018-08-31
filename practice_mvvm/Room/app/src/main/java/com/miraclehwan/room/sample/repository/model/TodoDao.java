package com.miraclehwan.room.sample.repository.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo_table ORDER BY todo ASC")
    LiveData<List<Todo>> getTodoList();

    @Insert
    void insert(Todo todo);

    @Query("DELETE FROM todo_table")
    void deteleAll();
}
