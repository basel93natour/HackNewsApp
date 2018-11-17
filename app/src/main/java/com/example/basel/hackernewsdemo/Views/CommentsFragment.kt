package com.example.basel.hackernewsdemo.Views

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.basel.hackernewsdemo.Adapter.CommentListAdapter
import com.example.basel.hackernewsdemo.Adapter.SimpleDividerItemDecoration
import com.example.basel.hackernewsdemo.Adapter.StoryListAdapter
import com.example.basel.hackernewsdemo.Contractor.CommentsView
import com.example.basel.hackernewsdemo.Contractor.DetailsPresenter
import com.example.basel.hackernewsdemo.DataModel.Comment
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Presenter.CommentsPresenter
import com.example.basel.hackernewsdemo.R

class CommentsFragment : Fragment(),CommentsView
{

    internal lateinit var presenter : CommentsPresenter
    internal lateinit var rootView : ViewGroup
    internal lateinit var commentsList : RecyclerView
    internal lateinit var kids : ArrayList<Int>
    internal lateinit var progressBar: ProgressBar
    internal var checkKids=true
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView =inflater.inflate(R.layout.comments_activity, container, false) as ViewGroup
        //need to check if the Story's kids list is not empty
         checkKids=!arguments!!.getIntegerArrayList("Kids").orEmpty().isEmpty()
        if (checkKids) {
            kids = arguments!!.getIntegerArrayList("Kids") as ArrayList<Int>
        }
        presenter= CommentsPresenter(this)
        presenter.intiPresenter()
        return rootView
    }

    override fun initView() {
        commentsList=rootView.findViewById(R.id.comments_list)
        commentsList.setLayoutManager(LinearLayoutManager(activity!!))
        progressBar=rootView.findViewById(R.id.progressBar)
        showLoading()
        if (checkKids)
        presenter.showComments(kids)
    }
    override fun showLoading() {
        progressBar.visibility=android.view.View.VISIBLE
    }
    override fun hideLoading() {
        progressBar.visibility=android.view.View.INVISIBLE
    }
    override fun showComments(comments: ArrayList<Comment>) {
        val adapter = CommentListAdapter(activity!!, comments)
        //add divider between list items
        commentsList.addItemDecoration(SimpleDividerItemDecoration(
                activity!!.applicationContext
        ));
        //assign the adapter to the recyclerView
        commentsList.setAdapter(adapter)
    }
}