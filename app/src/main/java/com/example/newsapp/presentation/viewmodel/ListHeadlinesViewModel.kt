package com.example.newsapp.presentation.viewmodel

import android.util.Log
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.api.entity.response.Article
import com.example.newsapp.domain.entity.ListHeadlinesEvent
import com.example.newsapp.domain.usecase.deleteallarticles.DeleteAllArticlesUseCase
import com.example.newsapp.domain.usecase.getallarticles.GetAllArticlesUseCase
import com.example.newsapp.domain.usecase.getlistnews.GetListNewsUseCase
import com.example.newsapp.domain.usecase.insertallarticles.InsertAllArticlesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListHeadlinesViewModel(
    private val getListNewsUseCase: GetListNewsUseCase,
    private val getAllArticlesUseCase: GetAllArticlesUseCase,
    private val insertAllArticlesUseCase: InsertAllArticlesUseCase,
    private val deleteAllArticlesUseCase: DeleteAllArticlesUseCase
) : ViewModel() {

    private val event = MutableLiveData<ListHeadlinesEvent?>()

    init {
        getListNews()
    }

    private fun getListNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getListNewsUseCase().onSuccess { result ->
                    val articles = result.value.articles
                    deleteAllArticlesUseCase()
                    insertAllArticlesUseCase(articles)
                    event.postValue(ListHeadlinesEvent.GetListNews(articles))
                }.onError {
                    val articles: List<Article> = getAllArticlesUseCase()
                    Log.e("ListHeadlinesViewModel","${articles.size}")
                    event.postValue(ListHeadlinesEvent.GetAllArticles(articles))
                }
            }
        }
    }

    fun onArticleClicked(article: Article) {
        val bundle = bundleOf(KEY_ARTICLE to article)
        event.value = ListHeadlinesEvent.ArticleClicked(bundle)
    }

    fun resetEvent() {
        event.value = null
    }

    fun getEvent(): LiveData<ListHeadlinesEvent?> = event

    companion object {

        const val KEY_ARTICLE = "key.article"
    }

}