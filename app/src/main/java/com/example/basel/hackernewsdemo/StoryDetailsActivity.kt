package com.example.basel.hackernewsdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import com.example.basel.hackernewsdemo.DataModel.Story


class StoryDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val storyDetails = intent.getSerializableExtra("Story") as Story
    }
}
