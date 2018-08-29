package com.miraclehwan.livedata;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.miraclehwan.livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner{

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;
    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        lifecycleRegistry = new LifecycleRegistry(this);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        binding.setMainViewModel(mainViewModel);

        mainViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.textview.setText(s);
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, MainFragment.newInstance())
                .commit();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("miraclehwan", "onDestroy");
    }
}