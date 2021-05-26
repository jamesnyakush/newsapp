package com.newsapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.newsapp.data.local.entity.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(article: List<Article>)

    @Query("SELECT * FROM articles")
    fun fetchNews(): Flow<List<Article>>
}