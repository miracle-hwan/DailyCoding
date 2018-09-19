package com.miraclehwan.myworkmanager;


import android.support.annotation.NonNull;

import androidx.work.Worker;

public class SimpleWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {

        WorkDao workDao = MyRoom.getsInstance(getApplicationContext()).workDao();
        workDao.insert(new Work());

        return Result.SUCCESS;
    }
}
