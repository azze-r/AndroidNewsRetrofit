package com.example.mynews.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews.R
import com.example.mynews.adapters.ArticleAdapter
import com.example.mynews.api.RestApiService

class ArticlesListFragment : Fragment() {

    lateinit var recyclerArticles: RecyclerView

    private lateinit var viewModel: ArticlesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.articles_list_fragment, container, false)
        recyclerArticles = root.findViewById(R.id.recyclerArticles)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ArticlesListViewModel::class.java)

        val apiService = RestApiService()

        apiService.getProducts {
            val articleAdapter = ArticleAdapter(this)
            articleAdapter.addAll(it.articles)
            articleAdapter.notifyDataSetChanged()
            recyclerArticles.adapter?.notifyDataSetChanged()
            recyclerArticles.adapter = articleAdapter
            recyclerArticles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

    }

}