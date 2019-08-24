package com.miraclehwan.viewmodeldi.di.module

import com.miraclehwan.viewmodeldi.model.Person
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class PersonModule {

    @Provides
    @Named("me")
    fun providePerson(): Person {
        return Person("miraclehwan")
    }

    @Provides
    @Named("avicii")
    fun provideAvicii(): Person {
        return Person("avicii   ")
    }
}