package com.sm.tech.letmesee.presenter.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener


class NewsViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val textViewOne: TextView = view.findViewById(R.id.TextViewOne)
    private val recyclerView: View = view.findViewById(R.id.card_view)

    fun bindText(news: Articles, clickListener: OnItemClickListener)
    {
        val itemNewss = news.title
        this.textViewOne.text = itemNewss.toString()

        recyclerView.setOnClickListener {
            clickListener.onItemClicked(news)
        }
    }

}