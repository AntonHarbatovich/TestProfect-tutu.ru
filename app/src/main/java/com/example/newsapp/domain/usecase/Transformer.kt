package com.example.newsapp.domain.usecase

import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.data.api.entity.response.Source
import com.example.newsapp.data.db.entity.ArticleEntity
import com.example.newsapp.data.db.entity.SourceEntity

object Transformer {
     fun convertArticleToArticleEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            author = article.author,
            content = article.content,
            source = convertSourceToSourceEntity(article.source),
            description = article.description,
            publishedAt = article.publishedAt,
            url = article.url,
            urlToImage = article.urlToImage,
            title = article.title
        )
    }
    fun convertArticleEntityToArticle(articleEntity: ArticleEntity): Article {
        return Article(
            author = articleEntity.author,
            content = articleEntity.content,
            source = convertSourceEntityToSource(articleEntity.source),
            description = articleEntity.description,
            publishedAt = articleEntity.publishedAt,
            url = articleEntity.url,
            urlToImage = articleEntity.urlToImage,
            title = articleEntity.title

        )
    }


    private fun convertSourceEntityToSource(sourceEntity: SourceEntity?): Source? {

        sourceEntity?.let {

            return Source(sourceEntity.id, sourceEntity.name)
        }

        return null
    }

    private fun convertSourceToSourceEntity(source: Source?): SourceEntity? {

        source?.let {
            return SourceEntity(source.id, source.name)
        }

        return null
    }
}