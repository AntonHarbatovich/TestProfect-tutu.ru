package com.example.newsapp.domain.usecase.getlistnews

import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result

interface GetListNewsUseCase {
    suspend operator fun invoke(): Result<NewsResponse>
}