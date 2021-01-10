package com.example.mynews.ui

import com.example.mynews.api.ArticlesRepository

object Injection {
    val repository: ArticlesRepository by lazy { ArticlesRepository() }
    val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory(repository)
    }
}