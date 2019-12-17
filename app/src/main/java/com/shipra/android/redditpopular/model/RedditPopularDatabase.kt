package com.shipra.android.redditpopular.model

import android.app.Application
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.shipra.android.redditpopular.dao.PopularListDao
import com.shipra.android.redditpopular.ui.MainPopularListPojo
import com.shipra.android.redditpopular.ui.PopularListPojo

@Database(
    entities = arrayOf(PopularListPojo::class, MainPopularListPojo::class),
    version = 1,
    exportSchema = false
)
abstract class RedditPopularDatabase private constructor() : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "reddit_database"
        val OBJECT_LOCK = Any()
        private lateinit var mInstance: RedditPopularDatabase

        fun getInstance(app: Application): RedditPopularDatabase {

            synchronized(OBJECT_LOCK) {
                mInstance =
                    Room.databaseBuilder(app, RedditPopularDatabase::class.java, DATABASE_NAME)
                        .build()
            }
            return mInstance;
        }
    }

    abstract override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper


    abstract override fun createInvalidationTracker(): InvalidationTracker


    override fun clearAllTables() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    abstract fun getRedditDao(): PopularListDao

}