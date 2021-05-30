package com.newsapp.ui.news.viewmodel

import androidx.lifecycle.*
import com.newsapp.data.State
import com.newsapp.data.network.NewsResponse
import com.newsapp.data.repository.NewsRepository
import com.newsapp.util.NetworkBoundResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {


    private val _newsResponse = MutableLiveData<State<NewsResponse>>()

    val newsResponse: LiveData<State<NewsResponse>> = _newsResponse

    fun fetchNews(country: String, category: String, apikey: String) {
        viewModelScope.launch {
            repository.fetchNews(country, category, apikey).collect { articles ->
                _newsResponse.value = articles
            }
        }
    }

    val fetchNewsFromLocal = repository.fetchNewsFromLocal().asLiveData()


    fun saveNewsToLocal() {
        // TODO: 28/05/21  
    }

    fun fetchNewsFromLocal() {
        // TODO: 28/05/21  
    }
}
