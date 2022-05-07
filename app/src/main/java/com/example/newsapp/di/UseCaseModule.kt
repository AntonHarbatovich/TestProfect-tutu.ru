package com.example.newsapp.di

import com.example.newsapp.domain.usecase.deleteallarticles.DeleteAllArticlesUseCase
import com.example.newsapp.domain.usecase.deleteallarticles.RealDeleteAllArticlesUseCase
import com.example.newsapp.domain.usecase.getallarticles.GetAllArticlesUseCase
import com.example.newsapp.domain.usecase.getallarticles.RealGetAllArticlesUseCase
import com.example.newsapp.domain.usecase.getlistnews.GetListNewsUseCase
import com.example.newsapp.domain.usecase.getlistnews.RealGetListNewsUseCase
import com.example.newsapp.domain.usecase.insertallarticles.InsertAllArticlesUseCase
import com.example.newsapp.domain.usecase.insertallarticles.RealInsertAllArticlesUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinModuleUseCase = module {

    single<GetListNewsUseCase> {
        RealGetListNewsUseCase(
            repository = get(),
            context = androidContext()
        )
    }

    single<GetAllArticlesUseCase> {
        RealGetAllArticlesUseCase(
            repository = get()
        )
    }

    single<InsertAllArticlesUseCase> {
        RealInsertAllArticlesUseCase(
            repository = get()
        )
    }

    single<DeleteAllArticlesUseCase> {
        RealDeleteAllArticlesUseCase(
            repository = get()
        )
    }
}