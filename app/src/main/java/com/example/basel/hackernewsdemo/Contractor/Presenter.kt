package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Story

interface Presenter
{
    fun getTopStories()
    fun onDestroy()
}