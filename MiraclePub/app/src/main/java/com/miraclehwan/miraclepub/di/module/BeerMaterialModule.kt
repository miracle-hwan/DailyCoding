package com.miraclehwan.miraclepub.di.module

import com.miraclehwan.miraclepub.model.material.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BeerMaterialModule {

    @Provides
    fun provideDunkelMaterial(): DunkelMaterial {
        return DunkelMaterial()
    }

    @Provides
    fun provideIndiaPaleAleMaterial(): IndiaPaleAleMaterial {
        return IndiaPaleAleMaterial()
    }

    @Provides
    fun providePaleAleMaterial(): PaleAleMaterial {
        return PaleAleMaterial()
    }

    @Provides
    fun providePaleLargerMaterial(): PaleLargerMaterial {
        return PaleLargerMaterial()
    }

    @Provides
    fun providePilsnerMaterial(): PilsnerMaterial {
        return PilsnerMaterial()
    }

    @Provides
    fun providePorterMaterial(): PorterMaterial {
        return PorterMaterial()
    }

    @Provides
    fun provideStoutMaterial(): StoutMaterial {
        return StoutMaterial()
    }

    @Provides
    fun provideWeizenMaterial(): WeizenMaterial {
        return WeizenMaterial()
    }

    @Provides
    fun provideWater(): Water {
        return Water()
    }
}