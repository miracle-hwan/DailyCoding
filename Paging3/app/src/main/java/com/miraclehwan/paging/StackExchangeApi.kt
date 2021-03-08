package com.miraclehwan.paging

import com.miraclehwan.paging.response.AnswerResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface StackExchangeApi {

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
                baseUrl("https://api.stackexchange.com/2.2/")
            }.build().create(StackExchangeApi::class.java)
        }
    }

    @GET("answers")
    suspend fun getAnswers(
        @Query("page") page: Int,
        @Query("pagesize") pagesize: Int,
        @Query("site") site: String
    ): Response<AnswerResponse>
}