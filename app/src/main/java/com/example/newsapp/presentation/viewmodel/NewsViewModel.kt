package com.example.newsapp.presentation.viewmodel

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.domain.entity.ListHeadlinesEvent
import com.example.newsapp.domain.entity.NewsEvent
import com.example.newsapp.presentation.viewmodel.ListHeadlinesViewModel.Companion.KEY_ARTICLE

class NewsViewModel(
    private val args: Bundle
) : ViewModel() {

    private val event = MutableLiveData<NewsEvent>()

    init {
        setArticle()
    }

    private fun setArticle() {
        val article: Article? = args.getParcelable(KEY_ARTICLE)
        event.value = NewsEvent.SetArticle(article!!)
    }

    fun getEvent(): LiveData<NewsEvent?> = event
}