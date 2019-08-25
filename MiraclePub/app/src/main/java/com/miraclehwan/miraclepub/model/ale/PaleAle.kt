package com.miraclehwan.miraclepub.model.ale

import com.miraclehwan.miraclepub.model.Ale
import com.miraclehwan.miraclepub.model.material.PaleAleMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class PaleAle @Inject constructor(val mWater: Water, val mPaleAleMaterial: PaleAleMaterial) : Ale()