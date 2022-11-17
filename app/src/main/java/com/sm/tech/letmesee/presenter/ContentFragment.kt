package com.sm.tech.letmesee.presenter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sm.tech.letmesee.data.entity.Articles
import com.sm.tech.letmesee.databinding.FragmentContentBinding
import com.squareup.picasso.Picasso


class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null
    private val binding get() = _binding

    private lateinit var articles: Articles


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articles = arguments?.get("data") as Articles

        val getLink = articles.urlToImage
       Picasso.get()
           .load(getLink)
           .into(binding?.fragmentContentImage)


        binding?.title?.text = articles.title
        binding?.detailAuthor?.text = articles.author
        binding?.detailDate?.text =articles.publishedAt
        binding?.detailFragmentDescription?.text = articles.description


        binding?.fragmentDetailBtn?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(articles.url)
            startActivity(intent)
        }
    }

}