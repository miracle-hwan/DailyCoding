package com.miraclehwan.miraclepub.model.larger

import com.miraclehwan.miraclepub.model.Larger
import com.miraclehwan.miraclepub.model.material.PilsnerMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class Pilsner @Inject constructor(val mWater: Water, val mPilsnerMaterial: PilsnerMaterial): Larger()