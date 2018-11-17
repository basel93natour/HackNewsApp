package com.example.basel.hackernewsdemo.MainPresenter

import com.example.basel.hackernewsdemo.Contractor.Presenter
import com.example.basel.hackernewsdemo.Contractor.View
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Model.MainModel

class MainPresenter (view : View?): Presenter {

    internal var mView =view
    internal lateinit var model: MainModel
    internal lateinit var Topstories : ArrayList<Story>
    fun intiPresenter()
    {
        model= MainModel()
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