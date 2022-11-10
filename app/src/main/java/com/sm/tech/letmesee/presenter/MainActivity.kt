package com.sm.tech.letmesee.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.network.LetMeSeeRemoteDataSourceImpl
import com.sm.tech.letmesee.domain.model.DataModel
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


        viewModel.getNewsList()
        viewModel.newsLiveData.observe(this) {
            adapter = RecyclerViewListAdapter(it,this)
            recyclerView.adapter=adapter
        }
    }

    override fun onItemClicked(item: DataModel) {
        TODO("Not yet implemented")
    }
}