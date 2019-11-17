package com.miraclehwan.dagger2_test.blog.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.miraclehwan.dagger2_test.blog.scope.RandomUserApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@RandomUserApplicationScope
@Module(includes = OkHttpClientModule.class)
public class PicassoModule {

    @Provides
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
