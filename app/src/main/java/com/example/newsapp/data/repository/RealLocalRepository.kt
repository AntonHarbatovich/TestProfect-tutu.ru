package com.example.newsapp.data.repository

import com.example.newsapp.data.db.LocalDataBase
import com.example.newsapp.data.db.entity.ArticleEntity
import com.example.newsapp.domain.repository.LocalRepository

class RealLocalRepository(
    private val localDataBase: LocalDataBase
) : LocalRepository {

    override suspend fun insertAllArticles(articles: List<ArticleEntity>) =
        localDataBase.localDao().insertAllArticles(articles)

    override suspend fun getAllArticles(): List<ArticleEntity> = localDataBase.localDao().getAll()

    override suspend fun deleteAllArticles() = localDataBase.localDao().deleteAll()

}
