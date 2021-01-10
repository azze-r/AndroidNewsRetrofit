package com.example.mynews.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mynews.R
import com.example.mynews.data.Articles
import com.example.mynews.utils.ImageUtils
import com.google.gson.Gson

class ArticleDetailFragment : Fragment() {

    lateinit var title: TextView
    lateinit var picture: ImageView
    lateinit var description: TextView
    lateinit var url: TextView

    private lateinit var viewModel: ArticleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.article_detail_fragment, container, false)
        title = root.findViewById(R.id.title)
        picture = root.findViewById(R.id.pic)
        description = root.findViewById(R.id.description)
        url = root.findViewById(R.id.url)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArticleDetailViewModel::class.java)
        val articleJson = arguments?.getString("articleJson")
        val article = Gson().fromJson(articleJson, Articles::class.java)
        Log.i("tryhard",article.toString())

        title.text = article.title
        ImageUtils.loadImage(article.urlToImage, R.mipmap.ic_launcher, picture)
        description.text = article.description
        url.text = article.url

        if (article.title.isEmpty())
            title.visibility = View.GONE

        if (article.urlToImage.isEmpty())
            picture.visibility = View.GONE

        if (article.description.isEmpty())
            description.visibility = View.GONE

        if (article.url.isEmpty())
            url.visibility = View.GONE
    }

}