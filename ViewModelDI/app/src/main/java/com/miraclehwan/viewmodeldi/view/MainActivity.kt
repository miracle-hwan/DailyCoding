package com.miraclehwan.viewmodeldi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.miraclehwan.viewmodeldi.R
import com.miraclehwan.viewmodeldi.viewmodel.BusViewModel
import com.miraclehwan.viewmodeldi.viewmodel.MainViewModel
import com.miraclehwan.viewmodeldi.viewmodel.SubwayViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subwayViewModel = ViewModelProviders.of(this).get(SubwayViewModel::class.java)
        tv_subway.setText("${subwayViewModel.mSubway.info} (${subwayViewModel.mSubway.number})")

        val busViewModel = ViewModelProviders.of(this).get(BusViewModel::class.java)
        tv_bus.setText("${busViewModel.mBus.info} (${busViewModel.mBus.number})")

        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        Log.e("MainViewModel Log", mainViewModel.mMyTransfer.toString())
        Log.e("MainViewModel Log", mainViewModel.mAviciiTransfer.toString())
    }
}
