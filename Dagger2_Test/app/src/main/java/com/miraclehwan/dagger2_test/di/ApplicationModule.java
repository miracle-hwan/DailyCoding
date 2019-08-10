package com.miraclehwan.dagger2_test.di;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class ApplicationModule {
    private Application mApp;

    public ApplicationModule(Application app){
        mApp = app;
    }

//    @Provides
//    @Singleton
//    SharedPreferences provideSharedPrefs(){
//        return PreferenceManager.getDefaultSharedPreferences(mApp);
//    }

    @Provides
    @Singleton
    @Named("default")
    SharedPreferences provideDefaultSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mApp);
    }

    @Provides
    @Singleton
    @Named("secret")
    SharedPreferences provideSecretSharedPrefs() {
        return mApp.getSharedPreferences("secret", Activity.MODE_PRIVATE); }
}
