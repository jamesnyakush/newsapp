package com.newsapp.ui.news.viewmodel

import androidx.lifecycle.ViewModel
import com.newsapp.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class NewsViewModel constructor(
    private val repository: NewsRepository
) : ViewModel() {

    fun fetchNews() {
        repository.fetchNews()
    }

    fun saveNewsToLocal() {

    }

    fun fetchNewsFromLocal() {

    }
}