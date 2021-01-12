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

    private lateinit var viewModel: ArticleDetailViewModel
    private var _binding: ArticleDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ArticleDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ArticleDetailViewModel::class.java)

        val articleJson = arguments?.getString("articleJson")
        val article = Gson().fromJson(articleJson, Articles::class.java)

        viewModel.setup(article)

        viewModel.title.observe(viewLifecycleOwner, Observer {
            binding.title.text = article.title
            if (article.title.isEmpty())
                binding.title.visibility = View.GONE
        })

        viewModel.pic.observe(viewLifecycleOwner, Observer {
            ImageUtils.loadImage(article.urlToImage, R.mipmap.ic_launcher, binding.pic)
            if (article.urlToImage.isEmpty())
                binding.pic.visibility = View.GONE
        })

        viewModel.description.observe(viewLifecycleOwner, Observer {
            binding.description.text = article.description
            if (article.description.isEmpty())
                binding.description.visibility = View.GONE
        })

        viewModel.url.observe(viewLifecycleOwner, Observer {
            binding.url.text = article.url
            if (article.url.isEmpty())
                binding.url.visibility = View.GONE
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}