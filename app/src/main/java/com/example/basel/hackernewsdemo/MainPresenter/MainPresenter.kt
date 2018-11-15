package com.example.basel.hackernewsdemo.MainPresenter

import android.util.Log
import com.example.basel.hackernewsdemo.Contractor.Presenter
import com.example.basel.hackernewsdemo.Contractor.View
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.NetworkService.onFinishedListener
import com.example.basel.hackernewsdemo.Model.MainModel
import com.google.gson.GsonBuilder

class MainPresenter (view : View?): Presenter {

    internal var mView =view
    internal lateinit var model: MainModel
    companion object {
        internal lateinit var topStoriesList: ArrayList<Story>
    }
    fun intiPresenter()
    {
        model= MainModel()
        mView!!.intiView()

    }
    override fun getTopStories(){
        topStoriesList=ArrayList<Story>()
            model.getTopStories(object : onFinishedListener {
                    override fun onSuccess(response: Story) {
                        if (mView!=null)
                        {
                            topStoriesList.add(response)
                            mView!!.showTopStories(topStoriesList)
                        }
                        }
                    override fun onFailed(message: String) {
                    if (mView!=null)
                        Log.d("Message",message)
                }
            })

    }
   //to avoid sending UI updates to finished activity
    override fun onDestroy() {
        mView=null
    }
}