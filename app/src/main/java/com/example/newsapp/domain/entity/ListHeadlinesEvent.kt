package com.example.newsapp.domain.entity

import android.os.Bundle
import com.example.newsapp.data.api.entity.response.Article

sealed class ListHeadlinesEvent {

    class ArticleClicked(val bundle: Bundle) : ListHeadlinesEvent()
    class GetListNews(val articles: List<Article>) : ListHeadlinesEvent()
    class GetAllArticles(val articles: List<Article>) : ListHeadlinesEvent()
}