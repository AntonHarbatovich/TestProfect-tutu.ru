package com.example.newsapp.data.api

import com.example.newsapp.data.api.entity.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getListNews(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("pageSize") pageSize:Int
    ) :Response<NewsResponse>
}