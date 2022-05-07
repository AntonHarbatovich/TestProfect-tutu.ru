package com.example.newsapp.domain.usecase.getallarticles

import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.domain.repository.LocalRepository
import com.example.newsapp.domain.usecase.Transformer.convertArticleEntityToArticle

class RealGetAllArticlesUseCase(
    private val repository: LocalRepository
) : GetAllArticlesUseCase {
    override suspend fun invoke(): List<Article> {
        val listArticleEntity = repository.getAllArticles()
        val listArticle: MutableList<Article> = mutableListOf()
        for (article in listArticleEntity) {
            listArticle.add(convertArticleEntityToArticle(article))
        }
        return listArticle
    }
}
