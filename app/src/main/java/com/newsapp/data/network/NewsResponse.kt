package com.newsapp.data.network

import com.newsapp.data.local.entity.Article

data class NewsResponse(
    val articles: List<Article>,
)