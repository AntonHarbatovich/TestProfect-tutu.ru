package com.example.newsapp.di

import com.example.newsapp.presentation.viewmodel.ListHeadlinesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModuleViewModel = module {

    viewModel {
        ListHeadlinesViewModel(
            getListNewsUseCase = get()
        )
    }
}