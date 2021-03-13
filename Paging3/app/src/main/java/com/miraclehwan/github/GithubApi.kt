package com.miraclehwan.github

import com.miraclehwan.github.Constant.API_TOKEN
import com.miraclehwan.github.response.GithubResponse
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface GithubApi {

    companion object {
        val instance by lazy {
            val httpClient = OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                addInterceptor { chain ->
                    val request =
                        chain.request().newBuilder().addHeader("Authorization", "$API_TOKEN")
                            .build()
                    chain.proceed(request)
                }
                connectTimeout(4, TimeUnit.SECONDS)
                readTimeout(4, TimeUnit.SECONDS)
                writeTimeout(4, TimeUnit.SECONDS)
            }.build()

            Retrofit.Builder().apply {
                client(httpClient)
                addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                addConverterFactory(GsonConverterFactory.create())
                baseUrl("https://api.github.com/")
            }.build().create(GithubApi::class.java)
        }
    }

    @GET("search/repositories")
    suspend fun getRepos(
        @Query("page") page: Int,
        @Query("q") text: String = "android"
    ): Response<GithubResponse>
}