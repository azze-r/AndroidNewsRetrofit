package com.example.mynews.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.mynews.R
import com.example.mynews.data.Articles
import com.example.mynews.databinding.ArticleDetailFragmentBinding
import com.example.mynews.utils.ImageUtils
import com.google.gson.Gson

class ArticleDetailFragment : Fragment() {

    private lateinit var binding: ArticleDetailFragmentBinding
    private lateinit var viewModel: ArticleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = ArticleDetailFragmentBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(ArticleDetailViewModel::class.java)

        val articleJson = arguments?.getString("articleJson")
        val article = Gson().fromJson(articleJson, Articles::class.java)

        viewModel.setup(article)

        viewModel.title.observe(viewLifecycleOwner, {
            binding.title.text = article.title
            if (article.title.isEmpty())
                binding.title.visibility = View.GONE
        })

        viewModel.pic.observe(viewLifecycleOwner, {
            ImageUtils.loadImage(article.urlToImage, R.mipmap.ic_launcher, binding.pic)
            if (article.urlToImage.isEmpty())
                binding.pic.visibility = View.GONE
        })

        viewModel.description.observe(viewLifecycleOwner, {
            binding.description.text = article.description
            if (article.description.isEmpty())
                binding.description.visibility = View.GONE
        })

        viewModel.url.observe(viewLifecycleOwner, {
            binding.url.text = article.url
            if (article.url.isEmpty())
                binding.url.visibility = View.GONE
        })

    }

}