package com.miraclehwan.room.sample;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application{

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        if (sInstance == null){
            sInstance = this;
        }
        Stetho.initializeWithDefaults(this);
    }

    public static MyApplication getsInstance() {
        return sInstance;
    }
}
