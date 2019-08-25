package com.miraclehwan.miraclepub.model.ale

import com.miraclehwan.miraclepub.model.Ale
import com.miraclehwan.miraclepub.model.material.Water
import com.miraclehwan.miraclepub.model.material.WeizenMaterial
import javax.inject.Inject

data class Weizen @Inject constructor(val mWater: Water, val mWeizenMaterial: WeizenMaterial) : Ale()