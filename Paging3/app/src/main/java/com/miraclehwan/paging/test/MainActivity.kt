package com.miraclehwan.paging.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.miraclehwan.paging.R
import com.miraclehwan.paging.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    val mainListAdapter = MainAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )

//        viewModel.listData.subscribe {
//            Log.e("daehwan", it.toString())
//                mainListAdapter.submitData(lifecycle,it)
//        }


        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainListAdapter
        }

        lifecycleScope.launch {
            viewModel.listData.collect {
                mainListAdapter.submitData(it)
            }
        }
    }
}