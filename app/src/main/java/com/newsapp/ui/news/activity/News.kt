package com.newsapp.ui.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.newsapp.R
import com.newsapp.data.DataResponse
import com.newsapp.ui.news.viewmodel.NewsViewModel
import com.newsapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class News : AppCompatActivity() {

    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_activity)

       // viewModel.fetchNews("us","business","75cdd7daba1e4339b7cbccfe40a620b6")

/*        viewModel.newsResponse.observe(this, Observer { state ->
            when(state) {
                is DataResponse.Success -> {
                    Timber.d( state.data.articles.toString())
                }
            }

            if (viewModel.newsResponse.value !is DataResponse.Success){
                viewModel.fetchNews("us","business","75cdd7daba1e4339b7cbccfe40a620b6")
            }
        })*/

        viewModel.news.observe(this, Observer { result ->
            when(result){
                is Resource.Success -> {
                    Timber.d(result.data.toString())
                    Toast.makeText(this, result.data.toString(), Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}