package com.example.newsapp.di

import com.example.newsapp.data.repository.RealNewsRepository
import com.example.newsapp.domain.repository.NewsRepository
import org.koin.dsl.module

val koinModuleRepository = module {

    single<NewsRepository> {
        RealNewsRepository(
            api = get()
        )
    }
}