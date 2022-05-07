package com.example.newsapp.domain.usecase.deleteallarticles

import com.example.newsapp.domain.repository.LocalRepository

class RealDeleteAllArticlesUseCase(
    private val repository: LocalRepository
) : DeleteAllArticlesUseCase {

    override suspend fun invoke() = repository.deleteAllArticles()
}
