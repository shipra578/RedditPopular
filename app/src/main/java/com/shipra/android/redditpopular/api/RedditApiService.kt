package com.shipra.android.redditpopular.api

import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*
import io.reactivex.Observable

interface RedditApiService {

    @GET("subreddits/popular/")
    fun getAllFrontRedditPopular() : Observable<Any>


    @GET("{url}")
    fun getAllRedditPopularDetails(@Path("url") url: String, id: String): Observable<Any>

}