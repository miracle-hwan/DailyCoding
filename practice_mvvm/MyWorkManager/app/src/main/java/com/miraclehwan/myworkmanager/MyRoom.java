package com.miraclehwan.myworkmanager;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Work.class}, version = 1)
public abstract class MyRoom extends RoomDatabase {

    public abstract WorkDao workDao();

    private static MyRoom sInstance;

    public static MyRoom getsInstance(Context context) {
        if (sInstance == null){
            synchronized (MyRoom.class) {
                if (sInstance == null){
                    sInstance = Room.databaseBuilder(context,
                            MyRoom.class, "miracleworkmanaerDB").build();
                }
            }
        }
        return sInstance;
    }
}
