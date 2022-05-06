package com.example.newsapp.domain.entity

import android.os.Bundle
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.data.api.entity.response.NewsResponse

sealed class ListHeadlinesEvent {

    class ArticleClicked(val bundle: Bundle) : ListHeadlinesEvent()
    class GetListNews(val news: NewsResponse) : ListHeadlinesEvent()
}