package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.MainActivity;
import dagger.Component;

@Component(modules = BurgerModule.class)
public interface BurgerComponent {
    void inject(MainActivity activity);
}
