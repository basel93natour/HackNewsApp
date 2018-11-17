package com.example.basel.hackernewsdemo.Model

import com.example.basel.hackernewsdemo.Contractor.StoryModel
import com.example.basel.hackernewsdemo.DataModel.Comment
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
    override fun getTopStories() : Single<List<Story>> {
        //send request to get all top stories ids
        //after that we will take each id by itself and convert it to observable object to get the full details of the story
        //put 25 items on the list and return it to presenter
        return storyService.getTopStories
                .flatMap<Int> { itemsList-> Flowable.fromIterable(itemsList) }
                .flatMap <Story> { itemId ->  storyService.getStory(itemId)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .take(25)
                .toList()

    }

    override fun getComments(kids : ArrayList<Int>) : Single<List<Comment>> {

        return   Flowable
                .just<List<Int>>(kids)//emits the list
                .flatMap<Int> { list -> Flowable.fromIterable(list) }//emits one by one
                .flatMap<Comment> { integer -> storyService.getComments(integer)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .toList()

    }


}
