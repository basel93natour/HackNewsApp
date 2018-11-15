package com.example.basel.hackernewsdemo.NetworkService

interface onFinishedListener {
    fun onSuccess(response: String)
    fun onFailed(message : String)
}