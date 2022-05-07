package com.example.newsapp.domain.usecase.insertallarticles

import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.data.db.entity.ArticleEntity
import com.example.newsapp.domain.repository.LocalRepository
import com.example.newsapp.domain.usecase.Transformer.convertArticleToArticleEntity

class RealInsertAllArticlesUseCase(
    private val repository: LocalRepository
) : InsertAllArticlesUseCase {
    override suspend fun invoke(articles: List<Article>) {
        val listArticleEntity: MutableList<ArticleEntity> = mutableListOf()
        for (article in articles) {
            listArticleEntity.add(convertArticleToArticleEntity(article))
        }
        repository.insertAllArticles(listArticleEntity)
    }
}
