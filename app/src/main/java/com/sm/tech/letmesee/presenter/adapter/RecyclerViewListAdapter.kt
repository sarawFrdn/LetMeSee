package com.sm.tech.letmesee.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.domain.model.DataModel
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener
import com.sm.tech.letmesee.presenter.adapter.viewholder.NewsViewHolder

class RecyclerViewListAdapter(private val allNews: List<DataModel>,
private val itemClickListener: OnItemClickListener)
    : ListAdapter<DataModel,NewsViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val itemNews = allNews[position]
        holder.bindText(itemNews,itemClickListener)
    }
}

class DiffCallback : DiffUtil.ItemCallback<DataModel>(){
    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem.status == newItem.status
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }
}