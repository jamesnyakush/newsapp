package com.newsapp.di

import android.content.Context
import com.newsapp.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

/*    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesCourseDao(appDatabase: AppDatabase): MovieDao =
        appDatabase.movieDao()*/
}