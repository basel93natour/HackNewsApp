package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.NetworkService.onFinishedListener
import io.reactivex.Single

interface Model
{
    fun getStories()
    fun getTopStories() : Single<List<Story>>
    fun getStory(itemId : Int)
    fun getComments()
}