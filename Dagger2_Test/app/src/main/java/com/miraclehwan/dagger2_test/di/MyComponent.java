package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.MainActivity;
import com.miraclehwan.dagger2_test.model.Kitchen;
import dagger.Component;

@Component(modules = {ChefModule.class, KitchenModule.class})
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
