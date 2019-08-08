package com.miraclehwan.dagger2_test.di.component;

import android.app.Application;
import android.content.Context;
import com.miraclehwan.dagger2_test.data.DataManager;
import com.miraclehwan.dagger2_test.data.DbHelper;
import com.miraclehwan.dagger2_test.DemoApplication;
import com.miraclehwan.dagger2_test.data.SharedPrefsHelper;
import com.miraclehwan.dagger2_test.di.ApplicationContext;
import com.miraclehwan.dagger2_test.di.module.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();
}
