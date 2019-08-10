package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.model.Chef;
import com.miraclehwan.dagger2_test.model.Kitchen;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class KitchenModule {

    @Provides
    Kitchen provideIsOrder(Chef chef, @Named("course1") String order) {
        return new Kitchen(chef, order);
    }

    @Provides
    @Named("course1")
    String provideCourse1() {
        return "Burger";
    }
}
