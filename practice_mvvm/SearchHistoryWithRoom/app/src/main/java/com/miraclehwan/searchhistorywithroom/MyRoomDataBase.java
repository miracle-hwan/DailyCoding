package com.miraclehwan.searchhistorywithroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.miraclehwan.searchhistorywithroom.repos.model.History;
import com.miraclehwan.searchhistorywithroom.repos.model.HistoryDao;

@Database(entities = {History.class}, version = 1)
public abstract class MyRoomDataBase extends RoomDatabase{

    public abstract HistoryDao historyDao();

    private static MyRoomDataBase sInstance;

    public static MyRoomDataBase getsInstance() {
        if (sInstance == null){
            synchronized (MyRoomDataBase.class) {
                if (sInstance == null){
                    sInstance = Room.databaseBuilder(MyApplication.getsInstance(),
                    MyRoomDataBase.class, "history_database").build();
                }
            }
        }
        return sInstance;
    }
}
