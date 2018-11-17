package com.example.basel.hackernewsdemo.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.TextView
import com.example.basel.hackernewsdemo.Adapter.StoryDetailsAdapter
import com.example.basel.hackernewsdemo.Adapter.ViewPagerAdapter
import com.example.basel.hackernewsdemo.Contractor.DetailsView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Presenter.StoryDetailsPresenter
import com.example.basel.hackernewsdemo.R
import org.w3c.dom.Comment

class StoryDetailsActivity : AppCompatActivity(), DetailsView {

    internal lateinit var viewPager : ViewPager
    internal lateinit var tabs : TabLayout
    lateinit var preseneter : StoryDetailsPresenter
    internal lateinit var title : TextView
    internal lateinit var url : TextView
    internal lateinit var date_author : TextView

    internal lateinit var storyDetails : Story
    internal lateinit var detailsAdapter: StoryDetailsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_activity)
        preseneter = StoryDetailsPresenter(this)
        preseneter.intiPresenter()
    }

    override fun intiView() {
        val intent = intent
        storyDetails = intent.getSerializableExtra("Story") as Story
        viewPager=findViewById(R.id.viewpager_main)
        tabs=findViewById(R.id.tabs_main)
        title=findViewById(R.id.details_title)
        url=findViewById(R.id.details_url)
        date_author=findViewById(R.id.details_date_author)

        title.text=storyDetails.title
        url.text=storyDetails.url
        date_author.text=storyDetails.date()+"-"+storyDetails.by

        detailsAdapter=StoryDetailsAdapter(supportFragmentManager)
        setupViewPager(viewPager!!)
     }

    private fun setupViewPager(viewPager: ViewPager) {

        val articleFragment= ArticleFragment()
        // pass arguments to fragment
        val articleBundle = Bundle()
        articleBundle .putString("url", storyDetails.url!!)
        articleFragment.setArguments(articleBundle )

        val commentsFragment= CommentsFragment()
        val commentsBundle = Bundle()
        //check if there is comments
        if (!storyDetails.kids.orEmpty().isEmpty()) {
            commentsBundle.putIntegerArrayList("Kids", ArrayList(storyDetails.kids))
            commentsFragment.setArguments(commentsBundle)
        }
        detailsAdapter.addFragment(articleFragment, "Article")
        detailsAdapter.addFragment(commentsFragment, "Comments")
        viewPager.adapter = detailsAdapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}
