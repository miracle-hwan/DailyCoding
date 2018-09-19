package com.miraclehwan.searchhistorywithroom;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;

import com.miraclehwan.searchhistorywithroom.adapter.SearchHistoryAdapter;
import com.miraclehwan.searchhistorywithroom.databinding.ActivityMainBinding;
import com.miraclehwan.searchhistorywithroom.repos.model.History;
import com.miraclehwan.searchhistorywithroom.viewmodel.HistoryViewmodel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HistoryViewmodel historyViewmodel;
    private SearchHistoryAdapter searchHistoryAdapter;
    private List<History> historyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        historyViewmodel = ViewModelProviders.of(this).get(HistoryViewmodel.class);

        searchHistoryAdapter = new SearchHistoryAdapter(this, historyList);
        binding.actvInput.setAdapter(searchHistoryAdapter);

        historyViewmodel.getLiveHistoryList().observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(@Nullable List<History> histories) {
                searchHistoryAdapter.setHistoryList(histories);
            }
        });
        binding.actvInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.actvInput.showDropDown();
                return false;
            }
        });
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.actvInput.getText().length() > 0){
                    historyViewmodel.insert(new History(binding.actvInput.getText().toString()));
                    binding.actvInput.setText("");
                }
            }
        });
    }
}
