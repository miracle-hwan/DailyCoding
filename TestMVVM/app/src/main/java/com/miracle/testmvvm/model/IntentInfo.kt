package com.miracle.testmvvm.model

import android.os.Bundle

data class IntentInfo(
    val className: Class<*>,
    val bundle: Bundle = Bundle()
)