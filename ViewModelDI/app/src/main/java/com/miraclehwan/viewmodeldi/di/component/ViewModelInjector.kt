package com.miraclehwan.viewmodeldi.di.component

import com.miraclehwan.viewmodeldi.di.module.PersonModule
import com.miraclehwan.viewmodeldi.di.module.TransferModule
import com.miraclehwan.viewmodeldi.viewmodel.BusViewModel
import com.miraclehwan.viewmodeldi.viewmodel.MainViewModel
import com.miraclehwan.viewmodeldi.viewmodel.SubwayViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TransferModule::class, PersonModule::class])
interface ViewModelInjector {
    fun inject(busViewModel: BusViewModel)
    fun inject(subwayViewModel: SubwayViewModel)
    fun inject(mainViewModel: MainViewModel)
}