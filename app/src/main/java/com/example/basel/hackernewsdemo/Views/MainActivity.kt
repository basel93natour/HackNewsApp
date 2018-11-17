package com.example.basel.hackernewsdemo.Views

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Contractor.StoryView
import com.example.basel.hackernewsdemo.Presenter.MainStoryPresenter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.*
import com.example.basel.hackernewsdemo.Adapter.SimpleDividerItemDecoration
import com.example.basel.hackernewsdemo.Adapter.StoryListAdapter
import com.example.basel.hackernewsdemo.R

class MainActivity : AppCompatActivity(), StoryView {

    lateinit var preseneter : MainStoryPresenter
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var mContext : Context
    internal lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preseneter = MainStoryPresenter(this)
        preseneter.intiPresenter()
    }

    override fun intiView() {
        mContext=this
        recyclerView = findViewById<RecyclerView>(R.id.stories_list)
        progressBar=findViewById(R.id.progressBar)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        showLoading()
        preseneter.getTopStories()
    }
    override fun showLoading() {
        //show progress bar
        progressBar.visibility=android.view.View.VISIBLE

    }
    override fun hideLoading() {
       //hide progress bar
       progressBar.visibility=android.view.View.INVISIBLE
    }

    override fun showTopStories(stories: ArrayList<Story>) {
        // set up the RecyclerView and onItemclick listener
        val adapter = StoryListAdapter(this, stories,object : StoryListAdapter.onItemClickListener{
            override fun onItemClick(story: Story) {
                val intent = Intent(mContext, StoryDetailsActivity::class.java)
                intent.putExtra("Story", story)
                startActivity(intent)
            }
        })
        //add divider between list items
        recyclerView.addItemDecoration(SimpleDividerItemDecoration(
                getApplicationContext()
        ));
        //assign the adapter to the recyclerView
        recyclerView.setAdapter(adapter)
        }

    override fun goToStory(story: Story) {

    }

    override fun onDestroy() {
        super.onDestroy()
        preseneter.onDestroy()
    }
}
