package com.example.basel.hackernewsdemo.NetworkService


import com.example.basel.hackernewsdemo.DataModel.Story
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HNService {
    @GET("topstories.json")
    fun getTopStories(): Call<List<Int>>

    @GET("item/{itemID}.json")
    fun getStory(@Path("itemID") itemID: Int): Call<Story>
}