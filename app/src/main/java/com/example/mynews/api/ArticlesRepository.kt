package com.example.mynews.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mynews.data.Articles
import com.example.mynews.data.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesRepository {

    val liveData = MutableLiveData<List<Articles>>()

    fun getProducts( onResult: (NewsResponse) -> Unit){
        val retrofit = ServiceBuilder.buildService(ArticlesService::class.java)
        retrofit.getProducts().enqueue(
            object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    val productsResponse = response.body()
                    if (productsResponse != null) {
                        Log.i("tryhard", productsResponse.totalResults.toString())
                        liveData.value = productsResponse.articles

                        onResult(productsResponse)
                    }
                }
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                }
            })

    }
}