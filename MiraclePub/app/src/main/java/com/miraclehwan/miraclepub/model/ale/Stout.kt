package com.miraclehwan.miraclepub.model.ale

import com.miraclehwan.miraclepub.model.Ale
import com.miraclehwan.miraclepub.model.material.StoutMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class Stout @Inject constructor(val mWater: Water, val mStoutMaterial: StoutMaterial) : Ale()