package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.model.BeefPatty;
import com.miraclehwan.dagger2_test.model.Burger;
import com.miraclehwan.dagger2_test.model.WheatBun;
import dagger.Module;
import dagger.Provides;

@Module
public class BurgerModule {

    @Provides
    Burger provideBurger(WheatBun bun, BeefPatty beefPatty){
        return new Burger(bun, beefPatty);
    }

    @Provides
    WheatBun provideBun(){
        return new WheatBun();
    }

    @Provides
    BeefPatty providePatty(){
        return new BeefPatty();
    }
}
