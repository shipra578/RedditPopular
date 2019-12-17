package com.shipra.android.redditpopular.dagger

import android.app.Application

class App() : Application() {

    companion object {

        private var component: RedditComponent? = null

        fun getComponent(): RedditComponent? {
            if (component == null) {

                component = DaggerRedditComponent.create()
            }
            return component
        }
    }


    init {
        getComponent()?.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerRedditComponent.create()
    }


}