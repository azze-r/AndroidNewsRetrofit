package com.example.mynews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.R
import com.example.mynews.adapters.ArticleAdapter
import com.example.mynews.databinding.ArticleDetailFragmentBinding
import com.example.mynews.databinding.ArticlesListFragmentBinding

class ArticlesListFragment : Fragment() {
    private var _binding: ArticlesListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ArticlesListFragmentBinding.inflate(inflater, container, false)
        return binding.root
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
            binding.recyclerArticles.adapter?.notifyDataSetChanged()
            binding.recyclerArticles.adapter = articleAdapter
            binding.recyclerArticles.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        })

        model.getData()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}