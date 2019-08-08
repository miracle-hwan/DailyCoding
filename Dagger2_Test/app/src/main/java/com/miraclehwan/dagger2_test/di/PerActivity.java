package com.miraclehwan.dagger2_test.di;

import javax.inject.Qualifier;
import javax.inject.Scope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
