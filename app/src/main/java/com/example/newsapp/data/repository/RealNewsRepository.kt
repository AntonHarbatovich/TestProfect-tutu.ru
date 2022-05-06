package com.example.newsapp.data.repository

import com.example.newsapp.data.api.NewsApi
import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result
import com.example.newsapp.data.api.utils.apiCall
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.Dispatchers.IO

class RealNewsRepository(
    private val api: NewsApi
) : NewsRepository {

    override suspend fun getListNews(apiKey: String, country: String): Result<NewsResponse> =
        apiCall(IO) {
            api.getListNews(apiKey, country, 100).body()!!
        }
}