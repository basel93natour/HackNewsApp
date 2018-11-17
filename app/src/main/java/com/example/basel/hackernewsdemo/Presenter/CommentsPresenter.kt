package com.example.basel.hackernewsdemo.Presenter

import com.example.basel.hackernewsdemo.Contractor.CommentsView
import com.example.basel.hackernewsdemo.Contractor.DetailsPresenter
import com.example.basel.hackernewsdemo.Model.MainStoryModel

class CommentsPresenter(view : CommentsView) : DetailsPresenter
{
    var mView=view
    internal lateinit var model: MainStoryModel

    fun intiPresenter()
    {
        model= MainStoryModel()
        mView.initView()
    }

    override fun showComments(kids : ArrayList<Int>) {
       var comments= model.getComments(kids)
        comments.subscribe(
                {
                    comments->
                    mView.hideLoading()
                    mView.showComments(ArrayList(comments))
                }
        )

    }
}