package com.miraclehwan.miraclepub.model.ale

import com.miraclehwan.miraclepub.model.Ale
import com.miraclehwan.miraclepub.model.material.IndiaPaleAleMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class IndiaPaleAle @Inject constructor(val mWater: Water, val mIndiaPaleAleMaterial: IndiaPaleAleMaterial) : Ale()