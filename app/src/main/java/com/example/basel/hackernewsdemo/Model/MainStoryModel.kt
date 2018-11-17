package com.example.basel.hackernewsdemo.Model

import com.example.basel.hackernewsdemo.Contractor.StoryModel
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.NetworkService.HNService
import com.example.basel.hackernewsdemo.NetworkService.NetworkClient
import kotlin.collections.ArrayList
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainStoryModel : StoryModel {


    internal  lateinit var storyService : HNService
    final internal var id=0
    companion object {
        internal lateinit var topStoriesList: ArrayList<Story>
    }
    init {
        storyService=NetworkClient().getRetrofitInstance().create(HNService::class.java)
    }
    override fun getStories() {
    }
    override fun getTopStories() : Single<List<Story>> {
        storyService.getTopStories

        return storyService.getTopStories
                .flatMap<Int> { itemsList-> Flowable.fromIterable(itemsList) }
                .flatMap <Story> { itemId ->  storyService.getStory(itemId)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(25)
                .toList()

    }
    override fun getStory(itemId : Int) {
    }
    override fun getComments() {
    }


}
