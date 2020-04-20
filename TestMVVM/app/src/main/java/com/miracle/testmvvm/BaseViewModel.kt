package com.miracle.testmvvm

import androidx.lifecycle.ViewModel
import com.miracle.testmvvm.model.IntentInfo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

open class BaseViewModel : ViewModel() {
    val compositeDisposable = CompositeDisposable()

    val intentSubject: PublishSubject<IntentInfo> by lazy {
        PublishSubject.create<IntentInfo>()
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}