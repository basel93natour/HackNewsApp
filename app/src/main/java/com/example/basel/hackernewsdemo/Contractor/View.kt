package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Story

interface View
{
    fun intiView()
    fun showLoading()
    fun hideLoading()
    fun showTopStories(stories : ArrayList<Story>)
    fun goToStory(story: Story)

}