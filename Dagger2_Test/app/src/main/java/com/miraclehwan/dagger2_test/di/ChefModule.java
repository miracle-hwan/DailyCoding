package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.model.Chef;
import dagger.Module;
import dagger.Provides;

@Module
public class ChefModule {

    @Provides
    Chef provideChef() {
        return new Chef("Miracle", "Kim");
    }
}
