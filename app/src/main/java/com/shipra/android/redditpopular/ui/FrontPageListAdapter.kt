package com.shipra.android.redditpopular.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.shipra.android.redditpopular.R
import kotlinx.android.synthetic.main.fron_page_list_item.view.*

class FrontPageListAdapter(
    context: Context?,
    var mList: List<MainPopularList>,
    val clickListener: ListItemClickListener?
) :
    RecyclerView.Adapter<FrontPageListAdapter.FrontPageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrontPageViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.fron_page_list_item, parent, false)
        return FrontPageViewHolder(v)
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    override fun onBindViewHolder(holder: FrontPageViewHolder, position: Int) {

        holder.title.setText(mList.get(position).title)
        holder.desc.setText(mList.get(position).description)
        clickListener?.onFrontListClick(mList.get(position).url)
    }


    class FrontPageViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var viewDataBinding =
            DataBindingUtil.bind<ViewDataBinding>(itemView)!!.root
        var title =
            viewDataBinding.front_page_list_item_title
        var desc =
            viewDataBinding.front_page_list_item_desc

    }


}