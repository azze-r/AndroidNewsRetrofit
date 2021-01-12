package com.example.mynews.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.R
import com.example.mynews.adapters.ArticleAdapter
import com.example.mynews.databinding.ArticlesListFragmentBinding

class ArticlesListFragment : Fragment() {

    private lateinit var binding: ArticlesListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.articles_list_fragment, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding = ArticlesListFragmentBinding.inflate(layoutInflater)

        val model: ArticlesListViewModel by viewModels {
            Injection.viewModelFactory
        }

        model.liveData.observe(viewLifecycleOwner, { result ->

            Log.i("tryhard", "fragment observe : " +result.size)

            val articleAdapter = ArticleAdapter()
            articleAdapter.addAll(result)
            articleAdapter.notifyDataSetChanged()
            binding.recyclerArticles.adapter?.notifyDataSetChanged()
            binding.recyclerArticles.adapter = articleAdapter
            binding.recyclerArticles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        })

        model.getData()


    }

}