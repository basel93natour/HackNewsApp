package com.example.basel.hackernewsdemo.NetworkService


import com.example.basel.hackernewsdemo.DataModel.Comment
import com.example.basel.hackernewsdemo.DataModel.Story
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HNService {

    @get:GET("topstories.json")
    val getTopStories: Flowable<List<Int>>

    @GET("item/{item_number}.json")
    fun getStory(@Path("item_number") item: Int): Flowable<Story>

    @GET("item/{item_number}.json")
    fun getComments(@Path("item_number") item: Int): Flowable<Comment>

}