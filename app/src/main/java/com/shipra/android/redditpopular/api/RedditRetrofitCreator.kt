package com.shipra.android.redditpopular.api

import com.shipra.android.redditpopular.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RedditRetrofitCreator {
    companion object {
         fun newApiService(): RedditApiService? {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(loggingInterceptor)
            builder.addInterceptor(RedditInterceptor())
            builder.connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
            val client = builder.build()
            val retrofit: Retrofit =
                Retrofit.Builder().baseUrl(BuildConfig.MAIN_URL).addConverterFactory(
                    GsonConverterFactory.create()
                ).client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            return retrofit.create<RedditApiService>(RedditApiService::class.java)
        }
    }
}