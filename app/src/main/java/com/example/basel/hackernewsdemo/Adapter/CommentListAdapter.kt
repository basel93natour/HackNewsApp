package com.example.basel.hackernewsdemo.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.basel.hackernewsdemo.DataModel.Comment
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.R
import org.ocpsoft.prettytime.PrettyTime


class CommentListAdapter(context: Context, val mData: ArrayList<Comment>) : RecyclerView.Adapter<CommentListAdapter.ListHolder>() {

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val comment= mData[position]
        holder.text.text =comment.text
        holder.date.text =comment.date()+"-"
        holder.author.text =comment.by
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.commentslist_item, parent, false)

        return ListHolder(view)
    }


    inner class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var text: TextView
        internal var date: TextView
        internal var author: TextView

        init {
            text = itemView.findViewById(R.id.comment_text)
            date = itemView.findViewById(R.id.comment_time)
            author = itemView.findViewById(R.id.comment_author)

        }

    }
}