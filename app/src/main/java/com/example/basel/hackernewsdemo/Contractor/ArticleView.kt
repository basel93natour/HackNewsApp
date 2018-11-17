package com.example.basel.hackernewsdemo.Contractor

import android.view.ViewGroup

interface ArticleView
{
    fun initView()
    fun ShowLoading()
    fun HideLoading()
    fun showArticle(url : String)

}