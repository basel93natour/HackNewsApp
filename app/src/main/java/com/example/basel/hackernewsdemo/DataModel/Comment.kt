package com.example.basel.hackernewsdemo.DataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.ocpsoft.prettytime.PrettyTime

class Comment {

    @SerializedName("by")
    @Expose
    var by: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("kids")
    @Expose
    var kids: List<Int>? = null
    @SerializedName("parent")
    @Expose
    var parent: Int? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    fun date() : String
    {
        val time = java.util.Date(time!!.toLong() * 1000)
        val p = PrettyTime()
        return p.format(time).toString()
    }
}