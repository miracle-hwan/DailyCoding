package com.miraclehwan.miraclepub.model.ale

import com.miraclehwan.miraclepub.model.Ale
import com.miraclehwan.miraclepub.model.material.PorterMaterial
import com.miraclehwan.miraclepub.model.material.Water
import javax.inject.Inject

data class Porter @Inject constructor(val mWater: Water, val mPorterMaterial: PorterMaterial) : Ale()