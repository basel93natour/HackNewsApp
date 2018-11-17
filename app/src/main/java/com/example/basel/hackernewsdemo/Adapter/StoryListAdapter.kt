package com.example.basel.hackernewsdemo.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.R
import org.ocpsoft.prettytime.PrettyTime


class StoryListAdapter(context: Context, val mData: ArrayList<Story>,var mListener:onItemClickListener) : RecyclerView.Adapter<StoryListAdapter.ListHolder>() {

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val story= mData[position]
        var number=position+1
        holder.number.text =number.toString()
        holder.points.text =story.score.toString()+"P"
        holder.title.text =story.title
        holder.url.text =story.url
        holder.date.text =story.date()+"-"
        holder.author.text =story.by
        holder.comments_number.text=story.descendants.toString()
        holder.itemView.setOnClickListener { mListener.onItemClick(story) }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.storylist_item, parent, false)

        return ListHolder(view)
    }


    inner class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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

    public interface onItemClickListener {
        fun onItemClick(story: Story)
        
    }
}