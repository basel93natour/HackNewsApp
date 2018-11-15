package com.example.basel.hackernewsdemo.Adapter

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.R
import org.ocpsoft.prettytime.PrettyTime




class StoryListAdapter
internal constructor(context: Context, private val mData: ArrayList<Story>) : RecyclerView.Adapter<StoryListAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater
    private var mClickListener: ItemClickListener? = null

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    // inflates the row layout from xml when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.storylist_item, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the TextView in each row
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val story= mData[position]
        var number=position+1
        holder.number.text =number.toString()
        holder.points.text =story.score.toString()
        holder.title.text =story.title

        holder.url.text =story.url!!
        Log.d("URL",story.url!!)
        val time = java.util.Date(story.time!!.toLong() * 1000)
        val p = PrettyTime()

        holder.date.text =p.format(time).toString()+"-"
        holder.author.text =story.by
        holder.comments_number.text=story.descendants.toString()
    }

    // total number of rows
    override fun getItemCount(): Int {
        return mData.size
    }
    // stores and recycles views as they are scrolled off screen
    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var number: TextView
        internal var points: TextView
        internal var title: TextView
        internal var url: TextView
        internal var date: TextView
        internal var author: TextView
        internal var comments_number: TextView

        init {
            number = itemView.findViewById(R.id.story_number)
            points = itemView.findViewById(R.id.story_points)
            title = itemView.findViewById(R.id.story_title)
            url = itemView.findViewById(R.id.story_url)
            date = itemView.findViewById(R.id.story_date)
            author = itemView.findViewById(R.id.story_author)
            comments_number= itemView.findViewById(R.id.comments_number)
        }
    }

    // convenience method for getting data at click position
    internal fun getItem(id: Int): Story {
        return mData.get(id)
    }

    // allows clicks events to be caught
    internal fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}