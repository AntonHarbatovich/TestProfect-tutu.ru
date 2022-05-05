package com.example.newsapp.data.api.http

import com.example.newsapp.data.api.NewsApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createNewsApi(
    httpClient: OkHttpClient,
    hostUrl: String
): NewsApi =
    Retrofit
        .Builder()
        .baseUrl(hostUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(NewsApi::class.java)