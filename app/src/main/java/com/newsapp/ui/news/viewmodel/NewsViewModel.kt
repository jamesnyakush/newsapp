package com.newsapp.ui.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {


    fun fetchNews(
        country: String,
        category: String,
        apikey: String
    ) {
        // TODO: 28/05/21  
    }


    val fetchNewsFromLocal = repository.fetchNewsFromLocal().asLiveData()


    fun saveNewsToLocal() {
        // TODO: 28/05/21  
    }

    fun fetchNewsFromLocal() {
        // TODO: 28/05/21  
    }
}
