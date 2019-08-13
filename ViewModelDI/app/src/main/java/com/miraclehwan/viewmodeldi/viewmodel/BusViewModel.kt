package com.miraclehwan.viewmodeldi.viewmodel

import com.miraclehwan.viewmodeldi.model.Bus
import javax.inject.Inject

class BusViewModel : BaseViewModel() {

    @Inject
    lateinit var mBus: Bus
}