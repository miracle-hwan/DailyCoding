package com.miraclehwan.paging.test

import com.miraclehwan.paging.test.response.Response
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface Api {

    companion object {
        val instance by lazy {
            val httpClient = OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                connectTimeout(4, TimeUnit.SECONDS)
                readTimeout(4, TimeUnit.SECONDS)
                writeTimeout(4, TimeUnit.SECONDS)
            }.build()

            Retrofit.Builder().apply {
                client(httpClient)
                addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://reqres.in/")
            }.build().create(Api::class.java)
        }
    }

    @GET("api/users")
    fun getListData(@Query("page") pageNumber: Int): Single<Response>

    @GET("api/users")
    suspend fun getListDataLegacy(@Query("page") pageNumber: Int): retrofit2.Response<Response>
}