package com.newsapp.util

object Keys {

    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}