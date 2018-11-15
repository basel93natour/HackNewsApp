package com.example.basel.hackernewsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.basel.hackernewsdemo.DataModel.Story
import com.example.basel.hackernewsdemo.Contractor.View
import com.example.basel.hackernewsdemo.MainPresenter.MainPresenter

class MainActivity : AppCompatActivity(), View {


    lateinit var preseneter : MainPresenter
    internal lateinit var txt : TextView
    internal lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.storylist_item)
        preseneter= MainPresenter(this)
      //  preseneter.intiPresenter()
    }
    override fun intiView() {
       // txt=findViewById(R.id.txt)
       // btn=findViewById(R.id.button)
      //  preseneter.getTopStories()
        }
    override fun showLoading() {
    }
    override fun hideLoading() {
    }

    override fun showTopStories(stories: ArrayList<Story>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTopStory(storyID : Int) {
        txt.setText("ID:"+storyID)
    }

    override fun onDestroy() {
        super.onDestroy()
        preseneter.onDestroy()
    }
}
