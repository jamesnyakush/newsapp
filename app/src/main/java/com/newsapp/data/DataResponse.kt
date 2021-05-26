package com.newsapp.data


sealed class DataResponse<out T> {
    class Loading<T> : DataResponse<T>()
    data class Success<T>(val data: T) : DataResponse<T>()
    data class Error<T>(val message: String) : DataResponse<T>()

    companion object {
        fun <T> loading() = Loading<T>()

        fun <T> success(data: T) = Success(data)

        fun <T> error(message: String) = Error<T>(message)
    }
}