package com.example.basel.hackernewsdemo.Views

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import com.example.basel.hackernewsdemo.Contractor.ArticleView
import com.example.basel.hackernewsdemo.Presenter.ArticlePresenter
import com.example.basel.hackernewsdemo.R
import android.webkit.WebViewClient
import android.webkit.WebSettings.PluginState
import android.widget.ProgressBar


class ArticleFragment (): Fragment(),ArticleView
{
    internal lateinit var article_page : WebView
    internal lateinit var presenter : ArticlePresenter
    internal lateinit var story_url : String
    internal lateinit var rootView : ViewGroup
    internal lateinit var progressBar: ProgressBar
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.article_activity, container, false) as ViewGroup
        story_url= arguments!!.getString("url") as String
        presenter=ArticlePresenter(this)
        presenter.intiPresenter()
        return rootView
    }
    override fun initView() {
        article_page=rootView.findViewById(R.id.article_page)
        progressBar=rootView.findViewById(R.id.progressBar)
        showArticle(story_url)
    }
    override fun showArticle(url: String) {
        ShowLoading()
        article_page.getSettings().setJavaScriptEnabled(true)
        article_page.getSettings().setPluginState(PluginState.ON)
        article_page.getSettings().setAllowFileAccess(true)

        article_page.loadUrl(url)

        article_page.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return false
            }
            override fun onPageFinished(view: WebView, url: String) {
                HideLoading()
            }
        })
    }

    override fun ShowLoading() {
        progressBar.visibility=android.view.View.VISIBLE
    }
    override fun HideLoading() {
        progressBar.visibility=android.view.View.INVISIBLE
    }
}