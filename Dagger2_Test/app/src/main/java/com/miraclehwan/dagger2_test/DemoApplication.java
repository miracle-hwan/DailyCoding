package com.miraclehwan.dagger2_test;

import android.app.Application;
import com.miraclehwan.dagger2_test.di.ApplicationComponent;
import com.miraclehwan.dagger2_test.di.ApplicationModule;
import com.miraclehwan.dagger2_test.di.DaggerApplicationComponent;

public class DemoApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
