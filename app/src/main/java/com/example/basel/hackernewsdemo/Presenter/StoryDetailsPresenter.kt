package com.example.basel.hackernewsdemo.Presenter

import com.example.basel.hackernewsdemo.Contractor.DetailsPresenter
import com.example.basel.hackernewsdemo.Contractor.DetailsView
import com.example.basel.hackernewsdemo.Model.MainStoryModel


class StoryDetailsPresenter (view : DetailsView?):DetailsPresenter
{
    internal var mView =view
    internal lateinit var model: MainStoryModel
    fun intiPresenter()
    {
        model= MainStoryModel()
        mView!!.intiView()

    }

    override fun showStoryArticle(url: String) {
    }

    override fun showComments() {
    }
}