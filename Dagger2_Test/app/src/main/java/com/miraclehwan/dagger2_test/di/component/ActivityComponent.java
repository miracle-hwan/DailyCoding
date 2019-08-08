package com.miraclehwan.dagger2_test.di.component;

import com.miraclehwan.dagger2_test.MainActivity;
import com.miraclehwan.dagger2_test.di.PerActivity;
import com.miraclehwan.dagger2_test.di.module.ActivityModule;
import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
