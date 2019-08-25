package com.miraclehwan.miraclepub.model.larger

import com.miraclehwan.miraclepub.model.Larger
import com.miraclehwan.miraclepub.model.material.DunkelMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class Dunkel @Inject constructor(val mWater: Water, val mDunkelMaterial: DunkelMaterial) : Larger()