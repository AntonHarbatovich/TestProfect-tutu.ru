package com.example.newsapp.data.api.entity.response

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
