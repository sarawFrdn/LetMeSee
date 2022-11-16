package com.sm.tech.letmesee.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener
import com.sm.tech.letmesee.presenter.ListFragment
import com.sm.tech.letmesee.presenter.adapter.viewholder.NewsViewHolder

class RecyclerViewListAdapter(
private val itemClickListener: ListFragment
)
    : ListAdapter<Articles,NewsViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindText( it,itemClickListener)
        }
        
    }
}

class DiffCallback : DiffUtil.ItemCallback<Articles>(){
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem == newItem
    }
}