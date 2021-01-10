package com.example.mynews.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mynews.api.ArticlesRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: ArticlesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>)
            : T = ArticlesListViewModel(repository) as T
}