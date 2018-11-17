package com.example.basel.hackernewsdemo.Presenter

import android.util.Log
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
                    mView.showComments(ArrayList(comments))
                }
        )
    }
}