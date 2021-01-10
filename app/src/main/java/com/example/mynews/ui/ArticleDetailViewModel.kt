package com.example.mynews.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynews.data.Articles

class ArticleDetailViewModel : ViewModel() {

    val title = MutableLiveData<String>()
    val pic = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val url = MutableLiveData<String>()

    fun setup(article: Articles) {
        // Daniel says make an api call to a server here. For now we'll fake it.
        title.value = article.title
        pic.value = article.urlToImage
        description.value = article.description
        url.value = article.url

    }

}