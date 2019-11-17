package com.miraclehwan.dagger2_test.blog.component;

import com.miraclehwan.dagger2_test.blog.MainActivity;
import com.miraclehwan.dagger2_test.blog.module.PicassoModule;
import com.miraclehwan.dagger2_test.blog.module.RandomUsersModule;
import com.miraclehwan.dagger2_test.blog.network.RandomUsersApi;
import com.miraclehwan.dagger2_test.blog.scope.RandomUserApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Component;

@RandomUserApplicationScope
@Component(modules = {RandomUsersModule.class, PicassoModule.class})
public interface RandomUserComponent {
    public void injectMainActivity(MainActivity mainActivity);
}
