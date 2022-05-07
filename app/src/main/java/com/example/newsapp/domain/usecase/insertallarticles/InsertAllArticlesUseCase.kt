package com.example.newsapp.domain.usecase.insertallarticles

import com.example.newsapp.data.api.entity.response.Article

interface InsertAllArticlesUseCase {

    suspend operator fun invoke(articles: List<Article>)
}