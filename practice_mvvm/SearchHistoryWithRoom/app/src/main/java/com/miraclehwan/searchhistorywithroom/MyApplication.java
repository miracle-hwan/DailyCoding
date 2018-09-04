package com.miraclehwan.searchhistorywithroom;

import android.app.Application;

public class MyApplication extends Application {

    private  static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (MyApplication.class) {
            if (sInstance == null) {
                sInstance = this;
            }
        }
    }

    public static MyApplication getsInstance() {
        return sInstance;
    }
}
