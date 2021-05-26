package com.newsapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newsapp.data.local.dao.NewsDao
import com.newsapp.data.local.entity.Article

@Database(
    entities = [Article::class],
    version = 1

)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}