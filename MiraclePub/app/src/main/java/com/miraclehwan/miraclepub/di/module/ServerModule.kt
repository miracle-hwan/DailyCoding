package com.miraclehwan.miraclepub.di.module

import com.miraclehwan.miraclepub.di.scope.ServerScope
import com.miraclehwan.miraclepub.model.Drink
import com.miraclehwan.miraclepub.model.ale.*
import com.miraclehwan.miraclepub.model.larger.Dunkel
import com.miraclehwan.miraclepub.model.larger.PaleLarger
import com.miraclehwan.miraclepub.model.larger.Pilsner
import com.miraclehwan.miraclepub.model.material.*
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import java.util.*
import java.util.UUID.randomUUID
import javax.inject.Named


@Module
class ServerModule {

    @Provides
    @ServerScope
    @Named("name")
    fun provideServerName(): String {
        return UUID.randomUUID().toString()
    }

    @Provides
    @IntoMap
    @ClassKey(IndiaPaleAle::class)
    fun provideIndiaPaleAle(water: Water, indiaPaleAleMaterial: IndiaPaleAleMaterial): Drink {
        return IndiaPaleAle(water, indiaPaleAleMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(PaleAle::class)
    fun providePaleAle(water: Water, paleAleMaterial: PaleAleMaterial): Drink {
        return PaleAle(water, paleAleMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(Porter::class)
    fun providePorter(water: Water, porterMaterial: PorterMaterial): Drink {
        return Porter(water, porterMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(Stout::class)
    fun provideStout(water: Water, stoutMaterial: StoutMaterial): Drink {
        return Stout(water, stoutMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(Weizen::class)
    fun provideWeizen(water: Water, weizenMaterial: WeizenMaterial): Drink {
        return Weizen(water, weizenMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(Dunkel::class)
    fun provideDunkel(water: Water, dunkelMaterial: DunkelMaterial): Drink {
        return Dunkel(water, dunkelMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(PaleLarger::class)
    fun providePaleLarger(water: Water, paleLargerMaterial: PaleLargerMaterial): Drink {
        return PaleLarger(water, paleLargerMaterial)
    }

    @Provides
    @IntoMap
    @ClassKey(Pilsner::class)
    fun providePilsner(water: Water, pilsnerMaterial: PilsnerMaterial): Drink {
        return Pilsner(water, pilsnerMaterial)
    }
}