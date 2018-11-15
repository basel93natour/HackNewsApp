package com.example.basel.hackernewsdemo.MainPresenter

import android.util.Log
import com.example.basel.hackernewsdemo.Contractor.Presenter
import com.example.basel.hackernewsdemo.Contractor.View
import com.example.basel.hackernewsdemo.NetworkService.onFinishedListener
import com.example.basel.hackernewsdemo.Model.MainModel
import com.google.gson.GsonBuilder

class MainPresenter (view : View?): Presenter {

    internal var mView =view
    internal lateinit var model: MainModel

    fun intiPresenter()
    {
        model= MainModel()
        mView!!.intiView()

    }
    override fun getTopStories(){

            model.getTopStories(object : onFinishedListener {
                    override fun onSuccess(response: String) {
                        if (mView!=null)
                        {

                            val builder = GsonBuilder()
                            val mGson = builder.create()
                            val storiesList = mGson.fromJson(response, Array<Int>::class.java).toList()

                            mView!!.getTopStory(storiesList.size)
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