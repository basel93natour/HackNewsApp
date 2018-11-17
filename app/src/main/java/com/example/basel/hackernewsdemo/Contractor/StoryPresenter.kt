package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Story

interface StoryPresenter
{
    fun getTopStories()
    fun onDestroy()
}