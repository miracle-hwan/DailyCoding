package com.miraclehwan.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.miraclehwan.paging.R
import com.miraclehwan.paging.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel by lazy { ViewModelProvider(this)[GithubViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.rvList.adapter = GithubAdapter()

        lifecycleScope.launch {
            viewModel.itemList.collect { data ->
                (binding.rvList.adapter as? GithubAdapter)?.submitData(data)
            }
        }
    }
}