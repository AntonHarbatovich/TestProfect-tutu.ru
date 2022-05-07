package com.example.newsapp.domain.usecase.deleteallarticles

import com.example.newsapp.data.api.entity.response.Article

interface DeleteAllArticlesUseCase {
    suspend operator fun invoke()
}