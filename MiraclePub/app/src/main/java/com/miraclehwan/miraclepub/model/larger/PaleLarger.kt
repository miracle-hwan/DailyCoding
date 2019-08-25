package com.miraclehwan.miraclepub.model.larger

import com.miraclehwan.miraclepub.model.Larger
import com.miraclehwan.miraclepub.model.material.PaleLargerMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class PaleLarger @Inject constructor(val mWater: Water, val mPaleLargerMaterial: PaleLargerMaterial) : Larger()