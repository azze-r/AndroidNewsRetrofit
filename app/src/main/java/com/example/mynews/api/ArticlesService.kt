package com.example.mynews.api

import com.example.mynews.BuildConfig
import com.example.mynews.data.NewsResponse
import retrofit2.Call
import retrofit2.http.*

interface ArticlesService {
    @Headers("Content-Type: application/json")
    @GET("top-headlines")
    fun getProducts(@Query("apiKey") apiKey: String = BuildConfig.NEWS_API_K,
                    @Query("country") query:String = "us",
                    ):
            Call<NewsResponse>
}