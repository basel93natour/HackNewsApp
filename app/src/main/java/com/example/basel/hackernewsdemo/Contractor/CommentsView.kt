package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Story

interface CommentsView
{
    fun intiView()
    fun showLoading()
    fun hideLoading()
    fun showComments(stories : ArrayList<Story>)
}