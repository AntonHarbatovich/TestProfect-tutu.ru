package com.example.newsapp.domain.usecase.getlistnews

import android.content.Context
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result
import com.example.newsapp.domain.repository.NewsRepository

class RealGetListNewsUseCase(
    private val repository: NewsRepository,
    private val apiKey: String,
    private val defaultCountry:String
) : GetListNewsUseCase {

    override suspend fun invoke(): Result<NewsResponse> =
        repository.getListNews(
            apiKey = apiKey,
            country = defaultCountry
        )

}
