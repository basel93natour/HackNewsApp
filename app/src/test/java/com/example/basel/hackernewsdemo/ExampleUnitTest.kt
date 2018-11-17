package com.example.basel.hackernewsdemo

import com.example.basel.hackernewsdemo.Contractor.StoryPresenter
import com.example.basel.hackernewsdemo.Contractor.StoryView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Model.MainStoryModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class MainStoryPresenterTest (): StoryPresenter {


    internal lateinit var mView: StoryView
    @Before
    fun getView(storyView : StoryView?)
    {
        mView=storyView!!
    }
    internal lateinit var model: MainStoryModel
    internal lateinit var Topstories : ArrayList<Story>

    @Before
    fun intiPresenter()
    {
        model= MainStoryModel()
        mView!!.intiView()

    }
    @Test
    override fun getTopStories(){

        model.getTopStories().subscribe({ stories->
            mView!!.hideLoading()
            mView!!.showTopStories(ArrayList(stories))
            Topstories=ArrayList(stories)
        })
    }

    @Test
    //to avoid sending UI updates to finished activity
    override fun onDestroy() {
       // mView=null
    }
}
