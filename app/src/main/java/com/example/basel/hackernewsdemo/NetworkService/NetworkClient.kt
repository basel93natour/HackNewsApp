package com.example.basel.hackernewsdemo.NetworkService

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory


 class NetworkClient
{

    var url="https://hacker-news.firebaseio.com/v0/"
    private var retrofit: Retrofit? = null

    public fun getRetrofitInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }
}