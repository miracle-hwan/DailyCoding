package com.miraclehwan.miraclepub.di.component

import com.miraclehwan.miraclepub.di.module.ServerModule
import com.miraclehwan.miraclepub.di.scope.ServerScope
import com.miraclehwan.miraclepub.model.Drink
import com.miraclehwan.miraclepub.model.Server
import dagger.Subcomponent
import javax.inject.Provider

@ServerScope
@Subcomponent(modules = ([ServerModule::class]))
interface ServerComponent {
    @Subcomponent.Builder
    interface Builder {
        fun serverModule(serverModule: ServerModule): Builder
        fun build(): ServerComponent
    }

    fun beerMap(): Map<Class<*>, Provider<Drink>>

    fun inject(server: Server)
}