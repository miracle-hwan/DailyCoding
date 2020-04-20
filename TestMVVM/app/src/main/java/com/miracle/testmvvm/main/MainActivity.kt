package com.miracle.testmvvm.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.miracle.testmvvm.R
import com.miracle.testmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            vm = mainViewModel
        }

        initObserver()
    }

    fun initObserver() {
        mainViewModel.compositeDisposable.add(
            mainViewModel.intentSubject
                .subscribe { intentInfo ->
                    startActivity(Intent(this, intentInfo.className).apply {
                        putExtras(intentInfo.bundle)
                    })
                })
    }
}
