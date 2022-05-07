package com.example.newsapp.domain.repository

import com.example.newsapp.data.db.entity.ArticleEntity

interface LocalRepository {
    suspend fun insertAllArticles(articles: List<ArticleEntity>)
    suspend fun getAllArticles(): List<ArticleEntity>
    suspend fun deleteAllArticles()
}