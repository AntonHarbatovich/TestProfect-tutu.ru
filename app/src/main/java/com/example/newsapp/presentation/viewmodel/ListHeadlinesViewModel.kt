package com.example.newsapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.domain.entity.ListHeadlinesEvent
import com.example.newsapp.domain.usecase.GetListNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListHeadlinesViewModel(
    private val getListNewsUseCase: GetListNewsUseCase
) : ViewModel() {

    private val event = MutableLiveData<ListHeadlinesEvent?>()

    init {
        getListNews()
    }

    private fun getListNews() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getListNewsUseCase().onSuccess { result ->
                    event.postValue(ListHeadlinesEvent.GetListNews(result.value))
                }
            }
        }
    }

    fun resetEvent() {
        event.value = null
    }

    fun getEvent(): LiveData<ListHeadlinesEvent?> = event
}