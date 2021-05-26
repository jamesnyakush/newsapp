package com.newsapp.data.repository

import com.newsapp.data.DataResponse
import com.newsapp.data.local.dao.NewsDao
import com.newsapp.data.local.entity.Article
import com.newsapp.data.network.ApiClient
import com.newsapp.data.network.NewsResponse
import com.newsapp.util.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
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

    fun fetch() = networkBoundResource(
        query = {
            dao.fetchNews()
        },
        fetch = {
            apiClient.getNews("us","business","75cdd7daba1e4339b7cbccfe40a620b6")
        },
        saveFetchResult = { news ->
            dao.saveNews(news.articles)
        }
    )


    suspend fun saveNewsToLocal(article: List<Article>) {
        dao.saveNews(article)
    }

/*    suspend fun fetchNewsFromLocal(): Flow<List<Article>> {
        return dao.fetchNews()
    }*/
}