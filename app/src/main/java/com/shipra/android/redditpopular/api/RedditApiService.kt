package com.shipra.android.redditpopular.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RedditApiService {

    @GET("subreddits/popular/")
    fun getAllFrontRedditPopular();


    @GET("{url}")
    fun getAllRedditPopularDetails(@Path("url") url: String, id: String)

}