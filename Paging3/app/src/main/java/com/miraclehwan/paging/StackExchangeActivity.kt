package com.miraclehwan.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.miraclehwan.paging.databinding.ActivityStackExcahngeBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StackExchangeActivity : AppCompatActivity() {

    lateinit var binding: ActivityStackExcahngeBinding
    val viewModel by lazy { ViewModelProvider(this)[StackExchangeViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stack_excahnge)

        binding.rvList.run {
            adapter = StackExchangeAdapter()
        }

        lifecycleScope.launch {
            viewModel.itemList.collect { data ->
                (binding.rvList.adapter as? StackExchangeAdapter)?.submitData(data)
            }
        }
    }
}