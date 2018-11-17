package com.example.basel.hackernewsdemo.Contractor

import com.example.basel.hackernewsdemo.DataModel.Comment
import com.example.basel.hackernewsdemo.DataModel.Story

interface CommentsView
{
    fun initView()
    fun showLoading()
    fun hideLoading()
    fun showComments(comments: ArrayList<Comment>)
}