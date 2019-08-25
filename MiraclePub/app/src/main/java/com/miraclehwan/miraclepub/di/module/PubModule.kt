package com.miraclehwan.miraclepub.di.module

import com.miraclehwan.miraclepub.di.component.ServerComponent
import com.miraclehwan.miraclepub.model.Server
import dagger.Module
import dagger.Provides

@Module(subcomponents = ([ServerComponent::class]))
class PubModule {

    @Provides
    fun provideServer(builder : ServerComponent.Builder) : Server {
        return Server(builder)
    }
}