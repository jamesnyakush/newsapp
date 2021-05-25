package com.newsapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,

        )
}