package com.newsapp.data.repository

import androidx.annotation.MainThread
import com.newsapp.data.DataResponse
import com.newsapp.data.network.NewsResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import retrofit2.Response

@ExperimentalCoroutinesApi
abstract class NetworkBoundRepository<T> {

    fun asFlow() = flow<DataResponse<T>> {

        // Emit Loading State
        emit(DataResponse.loading())

        try {
            // Fetch latest data from remote
            val apiResponse = fetchFromRemote()

            // Parse body
            val remotePosts = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && remotePosts != null) {
                emit(DataResponse.success(remotePosts))
            } else {
                // Something went wrong! Emit Error state.
                emit(DataResponse.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            emit(DataResponse.error("Network error! Can't get latest data."))
            e.printStackTrace()
        }
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<T>
}