package com.example.newsapp.data.api.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun createHttpClient(): OkHttpClient = OkHttpClient
    .Builder().apply {
        addNetworkInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }
    .build()
