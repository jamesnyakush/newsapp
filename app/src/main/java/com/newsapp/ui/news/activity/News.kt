package com.newsapp.ui.news.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.newsapp.R
import com.newsapp.data.State
import com.newsapp.data.local.entity.Article
import com.newsapp.ui.news.viewmodel.NewsViewModel
import com.newsapp.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import timber.log.Timber

@FlowPreview
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@AndroidEntryPoint
class News : AppCompatActivity() {

    private val viewModel by viewModels<NewsViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)

       viewModel.fetchNews("us", "business",Keys.apiKey())

        viewModel.newsResponse.observe(this, { articles ->
            when (articles) {
                is State.Loading -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is State.Success -> {
                    Toast.makeText(this, articles.data.articles.toString(), Toast.LENGTH_SHORT).show()
                    Timber.d(articles.data.articles.toString())
                }
                is State.Error -> {
                    Toast.makeText(this, articles.message, Toast.LENGTH_SHORT).show()
                }
                else -> Timber.d("Network Connection :(")
            }
        })

    }
}