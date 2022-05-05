package com.example.newsapp.domain.usecase

import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result

interface GetListNewsUseCase {
    suspend operator fun invoke(apiKey: String, country: String): Result<List<NewsResponse>>
}