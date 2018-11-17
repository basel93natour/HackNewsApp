package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Comment
import com.example.basel.hackernewsdemo.DataModel.Story
import io.reactivex.Single

interface StoryModel
{
    fun getTopStories() : Single<List<Story>>
    fun getComments(kids : ArrayList<Int>) : Single<List<Comment>>
}