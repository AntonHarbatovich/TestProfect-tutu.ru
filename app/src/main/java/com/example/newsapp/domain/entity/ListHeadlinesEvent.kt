package com.example.newsapp.domain.entity

import com.example.newsapp.data.api.entity.response.NewsResponse

sealed class ListHeadlinesEvent {

    class GetListNews(val news: NewsResponse) : ListHeadlinesEvent()
}