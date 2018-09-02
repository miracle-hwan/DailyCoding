package com.miraclehwan.paging.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.miraclehwan.paging.R;
import com.miraclehwan.paging.adapter.ItemAdapter;
import com.miraclehwan.paging.databinding.ActivityMainBinding;
import com.miraclehwan.paging.model.Item;
import com.miraclehwan.paging.viewmodel.ItemViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.rvAnswers.setLayoutManager(new LinearLayoutManager(this));
        final ItemAdapter itemAdapter = new ItemAdapter(this);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {
                itemAdapter.submitList(items);
            }
        });

        binding.rvAnswers.setAdapter(itemAdapter);
    }
}
