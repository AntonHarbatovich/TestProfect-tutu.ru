package com.example.newsapp.domain.usecase.getallarticles

import com.example.newsapp.data.api.entity.response.Article

interface GetAllArticlesUseCase {
    suspend operator fun invoke(): List<Article>
}