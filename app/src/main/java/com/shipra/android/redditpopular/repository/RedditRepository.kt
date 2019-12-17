package com.shipra.android.redditpopular.repository

import android.app.Application
import com.shipra.android.redditpopular.api.RedditApiService
import com.shipra.android.redditpopular.dagger.App
import com.shipra.android.redditpopular.model.RedditPopularDatabase
import com.shipra.android.redditpopular.ui.MainPopularListPojo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RedditRepository(app : Application) {

    @Inject lateinit var mService :  RedditApiService

    init {
        App.getComponent()?.inject(this)
        val mDatabase = RedditPopularDatabase.getInstance(app)
        val dao = mDatabase.getRedditDao()
    }

    fun getAllFrontList() : ArrayList<MainPopularListPojo> {

        val subscribeWith =
            mService.getAllFrontRedditPopular().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(object : DisposableObserver<Any>() {

                override fun onComplete() {

                }


                override fun onNext(t: Any) {

                }


                override fun onError(e: Throwable) {

                }

            })
        val array = arrayListOf<MainPopularListPojo>()
        return array;
    }

}