package com.newsapp.ui.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {



    /*
        private val _newsResponse = MutableLiveData<DataResponse<NewsResponse>>()

        val newsResponse: LiveData<DataResponse<NewsResponse>> = _newsResponse

        fun fetchNews(
            country: String,
            category: String,
            apikey: String
        ) = viewModelScope.launch {
            repository.fetchNews(country, category, apikey).collect{
                _newsResponse.value= it
            }
        }
    */


    val news = repository.fetch().asLiveData()


    fun saveNewsToLocal() {

    }

    fun fetchNewsFromLocal() {

    }
}
