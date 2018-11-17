package com.example.basel.hackernewsdemo.Presenter

import com.example.basel.hackernewsdemo.Contractor.ArticleView
import com.example.basel.hackernewsdemo.Contractor.DetailsPresenter
import com.example.basel.hackernewsdemo.Model.MainStoryModel

class ArticlePresenter(view : ArticleView)
{
    var mView=view
    internal lateinit var model: MainStoryModel

    fun intiPresenter()
    {
        mView.initView()
        model= MainStoryModel()
    }

}