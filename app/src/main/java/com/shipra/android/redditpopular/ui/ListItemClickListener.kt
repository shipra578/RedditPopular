package com.shipra.android.redditpopular.ui

import android.view.View

interface ListItemClickListener {

    fun onListItemClickListener(v: View, position: Int, obj: Any)
    fun onCommentsClicked(obj: PopularListPojo);
    fun onFavouriteClicked(obj: PopularListPojo);
    fun onUpvoteClicked(obj: PopularListPojo);
    fun onDownVoteClicked(obj: PopularListPojo);
    fun onShareClicked(obj: PopularListPojo);
    fun onFrontListClick(url: String)
}