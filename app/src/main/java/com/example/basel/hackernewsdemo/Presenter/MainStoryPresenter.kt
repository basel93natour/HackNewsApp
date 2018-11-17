package com.example.basel.hackernewsdemo.Presenter

import com.example.basel.hackernewsdemo.Contractor.StoryPresenter
import com.example.basel.hackernewsdemo.Contractor.StoryView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Model.MainStoryModel

class MainStoryPresenter (storyView : StoryView?): StoryPresenter {

    internal var mView =storyView
    internal lateinit var model: MainStoryModel
    internal lateinit var Topstories : ArrayList<Story>
    fun intiPresenter()
    {
        model= MainStoryModel()
        mView!!.intiView()

    }
    override fun getTopStories(){

            model.getTopStories().subscribe({ stories->
                mView!!.hideLoading()
                mView!!.showTopStories(ArrayList(stories))
                Topstories=ArrayList(stories)
            })
    }

    //to avoid sending UI updates to finished activity
    override fun onDestroy() {
        mView=null
    }
}