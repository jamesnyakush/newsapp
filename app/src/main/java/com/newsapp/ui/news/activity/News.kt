package com.newsapp.ui.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.newsapp.template.R


class News : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)
    }
}