package com.shipra.android.redditpopular.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shipra.android.redditpopular.dagger.App
import com.shipra.android.redditpopular.repository.RedditRepository

class RedditViewModel(application: Application) : AndroidViewModel(application) {


    private lateinit var repository : RedditRepository


    init {
        App.getComponent()?.inject(this)

    }


}