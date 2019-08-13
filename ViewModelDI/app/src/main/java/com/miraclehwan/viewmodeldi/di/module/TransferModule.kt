package com.miraclehwan.viewmodeldi.di.module

import com.miraclehwan.viewmodeldi.model.Bus
import com.miraclehwan.viewmodeldi.model.Subway
import dagger.Module
import dagger.Provides

@Module
class TransferModule {

    @Provides
    fun provideBus(): Bus {
        return Bus(123, "This is bus")
    }

    @Provides
    fun provideSubway(): Subway {
        return Subway(987, "This is subway")
    }
}
