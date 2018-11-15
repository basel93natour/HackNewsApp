package com.example.basel.hackernewsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.recyclerview.R.attr.layoutManager
import android.widget.Button
import android.widget.TextView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Contractor.View
import com.example.basel.hackernewsdemo.MainPresenter.MainPresenter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.support.v7.widget.DividerItemDecoration
import android.widget.LinearLayout.HORIZONTAL
import com.example.basel.hackernewsdemo.Adapter.SimpleDividerItemDecoration
import com.example.basel.hackernewsdemo.Adapter.StoryListAdapter


class MainActivity : AppCompatActivity(), View {


    lateinit var preseneter : MainPresenter
    internal lateinit var txt : TextView
    internal lateinit var btn: Button
    internal lateinit var recyclerView: RecyclerView
    var adapter: StoryListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preseneter= MainPresenter(this)
        preseneter.intiPresenter()

    }

    override fun intiView() {
        recyclerView = findViewById<RecyclerView>(R.id.stories_list)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        var stories=ArrayList<Story>()
        adapter = StoryListAdapter(this, stories)
        preseneter.getTopStories()
        recyclerView.addItemDecoration(SimpleDividerItemDecoration(
                getApplicationContext()
        ));
        recyclerView.setAdapter(adapter)

    }
    override fun showLoading() {
    }
    override fun hideLoading() {
    }

    override fun showTopStories(stories: ArrayList<Story>) {
        // set up the RecyclerView

        }

    override fun getTopStory(storyID : Int) {
        txt.setText("ID:"+storyID)
    }

    override fun onDestroy() {
        super.onDestroy()
        preseneter.onDestroy()
    }
}
