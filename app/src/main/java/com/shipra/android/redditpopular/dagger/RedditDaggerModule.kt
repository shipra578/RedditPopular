package com.shipra.android.redditpopular.dagger

import com.shipra.android.redditpopular.api.RedditApiService
import com.shipra.android.redditpopular.api.RedditRetrofitCreator
import dagger.Module
import dagger.Provides

@Module
class RedditDaggerModule {
    @Provides
    fun provideApiService(): RedditApiService? {
        return RedditRetrofitCreator.newApiService()
    }
}