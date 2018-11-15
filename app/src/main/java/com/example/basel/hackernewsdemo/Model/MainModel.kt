package com.example.basel.hackernewsdemo.Model

import android.util.Log
import com.example.basel.hackernewsdemo.Contractor.Model
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.NetworkService.onFinishedListener
import com.example.basel.hackernewsdemo.NetworkService.HNService
import com.example.basel.hackernewsdemo.NetworkService.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class MainModel : Model {


    internal  lateinit var storyService : HNService
    final internal var id=0
    init {
        storyService=NetworkClient().getRetrofitInstance().create(HNService::class.java)
    }
    override fun getStories() {
    }
    override fun getTopStories(onFinishedListener: onFinishedListener)  {

        var topStoriesCall =storyService.getTopStories()

        topStoriesCall.enqueue(object :Callback<List<Int>>
        {
            override fun onResponse(call: Call<List<Int>>, response: Response<List<Int>>) {
                var stories=ArrayList<Story>()
                for (storyid in response.body()!!)
                {
                    var story=Story()
                    story.id=storyid
                    stories.add(story)
                }
                //sort the Ids to get the latest
                Collections.sort(stories)
                //get the first 25 element only
                var topStories=stories.subList(0,24)

                for (story in topStories)
                {
                 var getStory=  storyService.getStory(story.id!!)
                    getStory.enqueue(object : Callback<Story>
                    {
                        override fun onFailure(call: Call<Story>, t: Throwable) {
                        }
                        override fun onResponse(call: Call<Story>, response: Response<Story>) {
                            onFinishedListener.onSuccess(response.body()!!)
                        }
                    })
                }
            }

            override fun onFailure(call: Call<List<Int>>, t: Throwable) {
                onFinishedListener.onFailed("FAILED"+t.message!!)
            }
        })

    }

    override fun getStory() {
    }
    override fun getComments() {
    }


}
