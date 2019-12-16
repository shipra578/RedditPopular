package com.shipra.android.redditpopular.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shipra.android.redditpopular.R
import com.shipra.android.redditpopular.ui.PopularListAdapter.MyViewHolder
import kotlinx.android.synthetic.main.popular_list_item_layout.view.*

class PopularListAdapter(
    context: Context?,
    var mList: List<PopularListPojo>,
    clickListener: ListItemClickListener?
) : RecyclerView.Adapter<MyViewHolder>() {


    var mListener: ListItemClickListener? = clickListener
    var curentPOs = 0;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_list_item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.downvote.setOnClickListener(commonListener)
        holder.upvote.setOnClickListener(commonListener)
        holder.comments.setOnClickListener(commonListener)
        holder.share.setOnClickListener(commonListener)
        holder.favourite.setOnClickListener(commonListener)
        curentPOs = holder.adapterPosition

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var viewDataBinding =
            DataBindingUtil.bind<ViewDataBinding>(itemView)!!.root
        var downvote =
            viewDataBinding.img_downvote
        var upvote =
            viewDataBinding.img_upvote
        var favourite =
            viewDataBinding.favourite
        var share =
            viewDataBinding.share_btn
        var comments =
            viewDataBinding.comments
        var description = viewDataBinding.headline_title
        var contentImage =
            viewDataBinding.content_image
    }

    var commonListener =
        View.OnClickListener { view ->
            when (view.id) {
                R.id.comments -> {
                    mListener?.onCommentsClicked(mList.get(curentPOs))
                }
                R.id.share_btn -> {
                    mListener?.onShareClicked(mList.get(curentPOs))
                }
                R.id.favourite -> {
                    mListener?.onFavouriteClicked(mList.get(curentPOs))
                }
                R.id.img_downvote -> {
                    mListener?.onDownVoteClicked(mList.get(curentPOs))
                }
                R.id.img_upvote -> {
                    mListener?.onUpvoteClicked(mList.get(curentPOs))
                }
            }
        }

}