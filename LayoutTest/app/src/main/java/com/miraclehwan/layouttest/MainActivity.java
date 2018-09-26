package com.miraclehwan.layouttest;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.miraclehwan.layouttest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.myProgressbar.setMaxValue(100);

        new Thread(() -> {
           while(true){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               runOnUiThread(() -> binding.myProgressbar.setCurrentValue(count));
               count++;
               if (count > 100){
                   count = 0;
               }
           }
        }).start();
    }
}
