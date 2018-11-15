package com.example.basel.hackernewsdemo.NetworkService


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HNService {
    @GET("topstories.json")
    fun getTopStories(): Call<List<Int>>
}