package com.example.basel.hackernewsdemo.DataModel
import java.io.Serializable;

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
class Story() : Comparable <Story>,Serializable {
    @SerializedName("by")
    @Expose
    var by:String?=null
    @SerializedName("descendants")
    @Expose
    var descendants:Int?=null
    @SerializedName("id")
    @Expose
    var id:Int?=null
    @SerializedName("kids")
    @Expose
    var kids:List<Int> ?=null
    @SerializedName("score")
    @Expose
    var score:Int?=null
    @SerializedName("time")
    @Expose
    var time:Int?=null
    @SerializedName("title")
    @Expose
    var title:String?=null
    @SerializedName("type")
    @Expose
    var type:String?=null
    @SerializedName("url")
    @Expose
    var url:String?=null

    override fun compareTo(story: Story): Int {
        return story.id!!.compareTo(this.id!!)
    }

}