package com.example.mynews.api

import android.util.Log
import com.example.mynews.data.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {

    fun getProducts( onResult: (NewsResponse) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getProducts().enqueue(
            object : Callback<NewsResponse> {
                override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                    val productsResponse = response.body()
                    Log.i("tryhard", call.request().url.toString())

                    Log.i("tryhard", productsResponse.toString())
                    if (productsResponse != null)
                        onResult(productsResponse)
                }
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.i("tryhard","products error : "+t.localizedMessage)
                }
            })

    }
}