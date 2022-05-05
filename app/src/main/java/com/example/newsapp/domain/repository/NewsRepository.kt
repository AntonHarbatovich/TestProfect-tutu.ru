package com.example.newsapp.domain.repository

import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result

interface NewsRepository {
    suspend fun getListNews(apiKey: String, country: String): Result<List<NewsResponse>>
}