package com.miraclehwan.viewmodeldi.viewmodel

import androidx.lifecycle.ViewModel
import com.miraclehwan.viewmodeldi.di.component.DaggerViewModelInjector

open class BaseViewModel : ViewModel() {

    val mInjector = DaggerViewModelInjector.create()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is BusViewModel -> mInjector.inject(this)
            is SubwayViewModel -> mInjector.inject(this)
        }
    }
}