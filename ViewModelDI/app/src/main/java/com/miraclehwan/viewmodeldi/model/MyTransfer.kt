package com.miraclehwan.viewmodeldi.model

import javax.inject.Inject
import javax.inject.Named

class MyTransfer @Inject constructor(@Named("me") val mPerson: Person, val mBus: Bus, val mSubway: Subway) {

    override fun toString(): String {
        return "Transfer(mPerson=$mPerson, mBus=$mBus, mSubway=$mSubway)"
    }
}