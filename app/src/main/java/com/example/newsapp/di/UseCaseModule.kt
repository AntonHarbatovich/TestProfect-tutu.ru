package com.example.newsapp.di

import com.example.newsapp.domain.usecase.GetListNewsUseCase
import com.example.newsapp.domain.usecase.RealGetListNewsUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinModuleUseCase = module {

    single<GetListNewsUseCase> {
        RealGetListNewsUseCase(
            repository = get(),
            context = androidContext()
        )
    }
}