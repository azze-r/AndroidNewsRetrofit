package com.example.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mynews.api.RestApiService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Log.i("tryhard","lets begin")

        val apiService = RestApiService()

        apiService.getProducts {
            Log.i("tryhard", it.totalResults.toString())
        }
    }
}