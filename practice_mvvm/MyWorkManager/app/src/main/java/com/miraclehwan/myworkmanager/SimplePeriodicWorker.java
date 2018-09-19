package com.miraclehwan.myworkmanager;


import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

public class SimplePeriodicWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {

        WorkDao workDao = MyRoom.getsInstance(getApplicationContext()).workDao();
        workDao.insert(new Work());

        return Result.SUCCESS;
    }
}
