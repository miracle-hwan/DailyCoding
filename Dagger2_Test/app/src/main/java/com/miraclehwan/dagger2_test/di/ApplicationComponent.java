package com.miraclehwan.dagger2_test.di;

import com.miraclehwan.dagger2_test.MainActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
