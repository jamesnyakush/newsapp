package com.newsapp.ui.news.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newsapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class News : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)

    }
}