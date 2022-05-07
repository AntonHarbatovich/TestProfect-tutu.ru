package com.example.newsapp.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ARTICLE")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    val source: SourceEntity?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
