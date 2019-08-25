package com.miraclehwan.miraclepub.di.component

import com.miraclehwan.miraclepub.MainActivity
import com.miraclehwan.miraclepub.di.module.BeerMaterialModule
import com.miraclehwan.miraclepub.di.module.PubModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = ([BeerMaterialModule::class, PubModule::class]))
interface PubComponent {
    fun inject(mainActivity: MainActivity)
}