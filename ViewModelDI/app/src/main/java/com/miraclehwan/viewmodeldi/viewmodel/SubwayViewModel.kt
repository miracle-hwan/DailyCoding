package com.miraclehwan.viewmodeldi.viewmodel

import com.miraclehwan.viewmodeldi.model.Bus
import com.miraclehwan.viewmodeldi.model.Subway
import javax.inject.Inject

class SubwayViewModel : BaseViewModel() {

    @Inject
    lateinit var mSubway: Subway
}