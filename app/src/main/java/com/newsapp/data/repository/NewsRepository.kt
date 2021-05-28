package com.newsapp.data.repository

import com.newsapp.data.local.dao.NewsDao
import com.newsapp.data.local.entity.Article
import com.newsapp.data.network.ApiClient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val dao: NewsDao,
    private val apiClient: ApiClient
) {

/*    @ExperimentalCoroutinesApi
    fun fetchNews(
        country: String,
        category: String,
        apikey: String
    ): Flow<DataResponse<NewsResponse>> {
        return object : NetworkBoundRepository<NewsResponse>() {
            override suspend fun fetchFromRemote(): Response<NewsResponse> =
                apiClient.getNews(country, category, apikey)

        }.asFlow().flowOn(Dispatchers.IO)
    }*/


    suspend fun saveNewsToLocal(article: List<Article>) {
        dao.saveNews(article)
    }


    fun fetchNewsFromLocal(): Flow<List<Article>> {
        return dao.fetchNews()
    }
}