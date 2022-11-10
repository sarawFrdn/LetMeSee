package com.sm.tech.letmesee.presenter.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.domain.model.DataModel
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener


class NewsViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val textView: TextView = view.findViewById(R.id.status)
    private val recyclerView: View = view.findViewById(R.id.recyclerView)

    fun bindText(news: DataModel, clickListener: OnItemClickListener)
    {
        this.textView.text = news.status
        recyclerView.setOnClickListener {
            clickListener.onItemClicked(news)
        }
    }

}