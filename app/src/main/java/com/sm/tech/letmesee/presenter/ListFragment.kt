package com.sm.tech.letmesee.presenter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sm.tech.letmesee.R
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.databinding.FragmentListBinding
import com.sm.tech.letmesee.domain.usecase.OnItemClickListener
import com.sm.tech.letmesee.presenter.adapter.RecyclerViewListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(),OnItemClickListener {

    private val viewModel: NewsViewModel by viewModel()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerViewListAdapter

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // this creates a vertical layout Manager
        linearLayoutManager = LinearLayoutManager(context)
        binding?.recyclerView?.layoutManager = linearLayoutManager

        adapter = RecyclerViewListAdapter(this)
        binding?.recyclerView?.adapter = adapter

        viewModel.newsLiveData.observe(viewLifecycleOwner) {
            it?.let {
                adapter.submitList(it.articles)
            }
        }


        binding?.submitBtn?.setOnClickListener {
            viewModel.getNewsList(query = binding!!.searchView.text.toString())
        }
    }

    override fun onItemClicked(item: Articles) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToContentFragment(item))
    }

}