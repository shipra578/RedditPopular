package com.shipra.android.redditpopular.dagger

import com.shipra.android.redditpopular.repository.RedditRepository
import com.shipra.android.redditpopular.viewModel.RedditViewModel
import dagger.Component

@AScope
@Component(modules = [RedditDaggerModule::class])
interface RedditComponent {

    fun inject(mainAppInstance: App?)

    fun inject(viewModel: RedditViewModel?)

    fun inject(popularRepository: RedditRepository?)

}