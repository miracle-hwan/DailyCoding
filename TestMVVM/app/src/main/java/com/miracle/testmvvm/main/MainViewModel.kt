package com.miracle.testmvvm.main

import android.os.Bundle
import com.miracle.testmvvm.BaseViewModel
import com.miracle.testmvvm.alpha.AlphaActivity
import com.miracle.testmvvm.beta.BetaActivity
import com.miracle.testmvvm.model.IntentInfo

class MainViewModel : BaseViewModel() {

    fun goAlpha() = intentSubject.onNext(IntentInfo(AlphaActivity::class.java))

    fun goBeta() {
        val bundle = Bundle().apply {
            putString("key", "this is key~~~~")
        }
        intentSubject.onNext(IntentInfo(BetaActivity::class.java, bundle))
    }
}