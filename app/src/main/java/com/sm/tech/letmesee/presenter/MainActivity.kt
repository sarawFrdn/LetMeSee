package com.sm.tech.letmesee.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener
import com.sm.tech.letmesee.presenter.adapter.RecyclerViewListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity(),OnItemClickListener {
    private val viewModel: NewsViewModel by viewModel()

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        // this creates a vertical layout Manager
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerViewListAdapter(this)
        recyclerView.adapter= adapter
        viewModel.getNewsList()
        viewModel.newsLiveData.observe(this) {
            it?.let {
            adapter.submitList(it.articles)
            }
        }

       /* viewModel.newsLiveData.observe(this, Observer { data->

            this.adapter=RecyclerViewListAdapter( ,this)
            recyclerView.adapter =this.adapter })*/
    }

    override fun onItemClicked(item: Articles) {
        TODO("Not yet implemented")
    }
}