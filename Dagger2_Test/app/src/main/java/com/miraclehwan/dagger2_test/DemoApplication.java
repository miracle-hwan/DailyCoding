package com.miraclehwan.dagger2_test;

import android.app.Application;
import android.content.Context;
import com.miraclehwan.dagger2_test.data.DataManager;
import com.miraclehwan.dagger2_test.di.component.ApplicationComponent;
import com.miraclehwan.dagger2_test.di.component.DaggerApplicationComponent;
import com.miraclehwan.dagger2_test.di.module.ApplicationModule;

import javax.inject.Inject;

public class    DemoApplication extends Application {

    ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
