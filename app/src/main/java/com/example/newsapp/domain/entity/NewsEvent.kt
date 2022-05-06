package com.example.newsapp.domain.entity

import com.example.newsapp.data.api.entity.response.Article

sealed class NewsEvent() {
    class SetArticle(val article: Article) : NewsEvent()
}
