package com.example.newsapp.di

import com.example.newsapp.data.repository.RealLocalRepository
import com.example.newsapp.data.repository.RealNewsRepository
import com.example.newsapp.domain.repository.LocalRepository
import com.example.newsapp.domain.repository.NewsRepository
import org.koin.dsl.module

val koinModuleRepository = module {

    single<NewsRepository> {
        RealNewsRepository(
            api = get()
        )
    }

    single<LocalRepository> {
        RealLocalRepository(
            localDataBase = get()
        )
    }
}