package com.example.basel.hackernewsdemo.NetworkService

import com.example.basel.hackernewsdemo.DataModel.Story

interface onFinishedListener {
    fun onSuccess(response: ArrayList<Story>)
    fun onFailed(message : String)
}