package com.example.basel.hackernewsdemo.Views

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basel.hackernewsdemo.Contractor.CommentsView
import com.example.basel.hackernewsdemo.Contractor.DetailsPresenter
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.R

class CommentsFragment : Fragment(),CommentsView
{

    internal lateinit var presenter : DetailsPresenter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.storylist_item, container, false)
    }

    override fun intiView() {
    }
    override fun showLoading() {
    }
    override fun hideLoading() {
    }
    override fun showComments(stories: ArrayList<Story>) {
    }
}