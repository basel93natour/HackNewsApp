package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.NetworkService.onFinishedListener

interface Model
{
    fun getStories()
    fun getTopStories(onFinishedListener: onFinishedListener)
    fun getStory()
    fun getComments()
}