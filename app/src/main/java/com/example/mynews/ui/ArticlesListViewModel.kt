package com.example.mynews.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynews.api.ArticlesRepository
import com.example.mynews.data.Articles

class ArticlesListViewModel(private val repository: ArticlesRepository) : ViewModel() {

    val liveData: MutableLiveData<List<Articles>> = repository.liveData
    fun getData() { repository.getProducts {
        liveData.value = it.articles
    } }
}