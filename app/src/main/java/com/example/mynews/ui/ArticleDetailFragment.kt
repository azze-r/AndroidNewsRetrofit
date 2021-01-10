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
import com.example.mynews.utils.ImageUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.article_detail_fragment.*

class ArticleDetailFragment : Fragment() {

    private lateinit var viewModel: ArticleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.article_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArticleDetailViewModel::class.java)

        val articleJson = arguments?.getString("articleJson")
        val article = Gson().fromJson(articleJson, Articles::class.java)

        viewModel.setup(article)

        viewModel.title.observe(viewLifecycleOwner, Observer {
            title.text = article.title
            if (article.title.isEmpty())
                title.visibility = View.GONE
        })

        viewModel.pic.observe(viewLifecycleOwner, Observer {
            ImageUtils.loadImage(article.urlToImage, R.mipmap.ic_launcher, pic)
            if (article.urlToImage.isEmpty())
                pic.visibility = View.GONE
        })

        viewModel.description.observe(viewLifecycleOwner, Observer {
            description.text = article.description
            if (article.description.isEmpty())
                description.visibility = View.GONE
        })

        viewModel.url.observe(viewLifecycleOwner, Observer {
            url.text = article.url
            if (article.url.isEmpty())
                url.visibility = View.GONE
        })

    }

}