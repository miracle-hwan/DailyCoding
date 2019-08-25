package com.miraclehwan.miraclepub.model

import com.miraclehwan.miraclepub.di.component.ServerComponent
import com.miraclehwan.miraclepub.di.module.ServerModule
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class Server @Inject constructor(builder: ServerComponent.Builder) {

    @Inject
    @field:Named("name")
    lateinit var mName: String

    //    @Inject
    lateinit var mBeerMap: Map<Class<*>, Provider<Drink>>

    init {
        val serverComponent = builder.serverModule(ServerModule()).build()
        serverComponent.inject(this)
        mBeerMap = serverComponent.beerMap()
    }

    fun <T : Drink> makeBeer(beerClass: Class<T>): T {
        return mBeerMap.get(beerClass)?.get() as T ?: throw IllegalArgumentException()
    }
}