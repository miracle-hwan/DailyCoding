package com.miraclehwan.viewmodeldi.model

import javax.inject.Inject
import javax.inject.Named

class AviciiTransfer @Inject constructor(@Named("avicii") val mPerson: Person, val mBus: Bus, val mSubway: Subway) {

    override fun toString(): String {
        return "Transfer(mPerson=$mPerson, mBus=$mBus, mSubway=$mSubway)"
    }
}