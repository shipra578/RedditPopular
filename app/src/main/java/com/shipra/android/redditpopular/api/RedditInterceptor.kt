package com.shipra.android.redditpopular.api

import okhttp3.Interceptor
import okhttp3.Response

class RedditInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
        val okhhtp3Url = originalRequest.url().newBuilder().build()
        requestBuilder.url(okhhtp3Url)
        return chain.proceed(requestBuilder.build())
    }
}