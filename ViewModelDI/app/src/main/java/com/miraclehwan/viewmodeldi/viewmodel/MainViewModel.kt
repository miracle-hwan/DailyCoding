package com.miraclehwan.viewmodeldi.viewmodel

import com.miraclehwan.viewmodeldi.model.AviciiTransfer
import com.miraclehwan.viewmodeldi.model.MyTransfer
import com.miraclehwan.viewmodeldi.model.Transfer
import javax.inject.Inject

class MainViewModel : BaseViewModel() {
    @Inject
    lateinit var mMyTransfer: MyTransfer

    @Inject
    lateinit var mAviciiTransfer: AviciiTransfer
}