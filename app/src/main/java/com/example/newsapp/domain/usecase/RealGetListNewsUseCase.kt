package com.example.newsapp.domain.usecase

import android.content.Context
import com.example.newsapp.R
import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result
import com.example.newsapp.domain.repository.NewsRepository

class RealGetListNewsUseCase(
    private val repository: NewsRepository,
    private val context: Context
) : GetListNewsUseCase {

    override suspend fun invoke(apiKey: String, country: String): Result<List<NewsResponse>> =
        repository.getListNews(context.getString(R.string.api_key), country)

}
