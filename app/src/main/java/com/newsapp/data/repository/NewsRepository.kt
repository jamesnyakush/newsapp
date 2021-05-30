package com.newsapp.data.repository

import com.newsapp.data.State
import com.newsapp.data.local.dao.NewsDao
import com.newsapp.data.local.entity.Article
import com.newsapp.data.network.ApiClient
import com.newsapp.data.network.NewsResponse
import com.newsapp.util.NetworkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

@ExperimentalCoroutinesApi
class NewsRepository @Inject constructor(
    private val dao: NewsDao,
    private val apiClient: ApiClient
) {

    fun fetchNews(
        country: String, category: String, apikey: String
    ): Flow<State<NewsResponse>> {

        return object : NetworkBoundResource<List<NewsResponse>>() {
            override suspend fun fetchFromRemote(): Response<List<NewsResponse>> =
                apiClient.getNews(country, category, apikey)

        }.asFlow().flowOn(Dispatchers.IO).map { article ->
            when (article) {
                is State.Loading -> State.loading()
                is State.Success -> {
                    val data = article.data.find { it.articles == article }

                    if (data != null) {
                        State.success(data)
                    } else {
                        State.error("No data found of state '$article'")
                    }
                }
                is State.Error -> {
                    State.error(article.message)
                }
            }

        }
    }

    suspend fun saveNewsToLocal(article: List<Article>) {
        dao.saveNews(article)
    }


    fun fetchNewsFromLocal(): Flow<List<Article>> {
        return dao.fetchNews()
    }
}