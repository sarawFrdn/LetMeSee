package com.sm.tech.letmesee.presenter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.contains
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener
import com.sm.tech.letmesee.presenter.adapter.RecyclerViewListAdapter
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale.filter


class MainActivity : AppCompatActivity(),OnItemClickListener {
    private val viewModel: NewsViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewListAdapter
    private lateinit var editText: EditText
    private lateinit var submitBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        submitBtn = findViewById(R.id.submitBtn)
        editText= findViewById(R.id.searchView)


        // this creates a vertical layout Manager
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        adapter = RecyclerViewListAdapter(this)
        recyclerView.adapter= adapter
        /*viewModel.getNewsList(query = editText.text.toString())*/
        viewModel.newsLiveData.observe(this) {
            it?.let {
            adapter.submitList(it.articles)
            }
        }

        submitBtn.setOnClickListener {
            viewModel.getNewsList(query = editText.text.toString())
        }

    }


    override fun onItemClicked(item: Articles) {
        TODO("Not yet implemented")
    }

}

