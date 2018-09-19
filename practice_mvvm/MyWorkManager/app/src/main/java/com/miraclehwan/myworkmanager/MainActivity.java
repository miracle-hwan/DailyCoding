package com.miraclehwan.myworkmanager;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        doWorkOneTime();
//        doWorkPeriodic();
//        doWorkWithConstraints();

//for example
//        WorkManager.getInstance().beginWith(work1).then(work2).enqueue();
//        WorkManager.getInstance().beginWith(filterWork1, filterWork2, filterWork3).then(compressWork).then(uploadWork).enqueue()

        findViewById(R.id.btn_start_work).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doWorkPeriodic();
            }
        });

        WorkDao workDao = MyRoom.getsInstance(getApplicationContext()).workDao();
        workDao.getWorkList().observe(this, new Observer<List<Work>>() {
            @Override
            public void onChanged(@Nullable List<Work> works) {
                List<String> timeDataList = new ArrayList<>(works.size());
                for (int i = 0; i < works.size(); i++) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    try {
                        Date date = simpleDateFormat.parse(works.get(i).getTime());
                        if (i != works.size()-1){
                            Date d1 = simpleDateFormat.parse(works.get(i).getTime());
                            Date d2 = simpleDateFormat.parse(works.get(i+1).getTime());
                            long diff = d1.getTime() - d2.getTime();
                            long sec = diff / 1000;
                            long min = sec / 60;
                            timeDataList.add(new SimpleDateFormat("MM/dd - HH:mm").format(date) + " (" + min + "분)");
                        }else{
                            timeDataList.add(new SimpleDateFormat("MM/dd - HH:mm").format(date));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                ((ListView) findViewById(R.id.lv_list)).setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, timeDataList));
            }
        });
    }

    private void doWorkOneTime(){
        OneTimeWorkRequest requestOneTime = new OneTimeWorkRequest
                .Builder(SimpleWorker.class).build();

        startWork(requestOneTime);
    }

    private void doWorkPeriodic(){
        //minimum interval 15 minutes
        PeriodicWorkRequest requestPeriodic = new PeriodicWorkRequest
                .Builder(SimplePeriodicWorker.class, 15, TimeUnit.MINUTES).build();

        WorkManager.getInstance()
                .enqueueUniquePeriodicWork("miracleJob", ExistingPeriodicWorkPolicy.KEEP, requestPeriodic);
    }

    private void doWorkWithConstraints(){
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true)
                .build();

        OneTimeWorkRequest requestConstraint = new OneTimeWorkRequest
                .Builder(SimpleWorker.class)
                .setConstraints(constraints).build();

        startWork(requestConstraint);
    }

    private void startWork(WorkRequest workRequest){
        WorkManager workManager = WorkManager.getInstance();
        workManager.enqueue(workRequest);
    }
}
