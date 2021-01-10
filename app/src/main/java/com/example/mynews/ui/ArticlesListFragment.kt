package com.example.mynews.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.R
import com.example.mynews.adapters.ArticleAdapter
import com.example.mynews.data.Articles
import kotlinx.android.synthetic.main.articles_list_fragment.*

class ArticlesListFragment : Fragment() {


    private lateinit var viewModel: ArticlesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.articles_list_fragment, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val model: ArticlesListViewModel by viewModels {
            Injection.viewModelFactory
        }

        model.liveData.observe(viewLifecycleOwner, { result ->
            val articleAdapter = ArticleAdapter()
            articleAdapter.addAll(result)
            articleAdapter.notifyDataSetChanged()
            recyclerArticles.adapter?.notifyDataSetChanged()
            recyclerArticles.adapter = articleAdapter
            recyclerArticles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        })

        model.getData()


    }

}