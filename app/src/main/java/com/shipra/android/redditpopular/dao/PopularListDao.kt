package com.shipra.android.redditpopular.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shipra.android.redditpopular.ui.MainPopularListPojo
import com.shipra.android.redditpopular.ui.PopularListPojo

@Dao
interface PopularListDao {

    @Query("select * from popular_table_front")
    fun loadAllFrontPopular(): MainPopularListPojo?

    @Query("select * from popular_table_detail")
    fun loadAllDetailPopular(): PopularListPojo?

    @Query("select * from popular_table_detail where id_front =:id")
    fun lodAllNewsWithCategory(id: String): PopularListPojo?

    @Insert
    fun insertPopular(popularList: PopularListPojo?)

    @Insert
    fun insertFrontList(popularList: MainPopularListPojo?)


}