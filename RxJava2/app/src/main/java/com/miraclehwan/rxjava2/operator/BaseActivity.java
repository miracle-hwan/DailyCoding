package com.miraclehwan.rxjava2.operator;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.miraclehwan.rxjava2.R;
import com.miraclehwan.rxjava2.databinding.ActivityBaseBinding;
import com.miraclehwan.rxjava2.databinding.ActivityMainBinding;

public class BaseActivity extends AppCompatActivity {

    protected ActivityBaseBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base);
    }
}
