package com.miraclehwan.room.sample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.miraclehwan.room.sample.repository.model.Todo;
import com.miraclehwan.room.sample.repository.model.TodoDao;

@Database(entities = {Todo.class}, version = 1)
public abstract class MyRoomDataBase extends RoomDatabase{

    public abstract TodoDao todoDao();

    private static MyRoomDataBase sInstance;

    public static MyRoomDataBase getsInstance() {
        if (sInstance == null){
            synchronized (MyRoomDataBase.class) {
                if (sInstance == null){
                    sInstance = Room.databaseBuilder(MyApplication.getsInstance(),
                    MyRoomDataBase.class, "todo_database").build();
                }
            }
        }
        return sInstance;
    }
}
