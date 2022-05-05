package com.example.newsapp

import android.app.Application
import com.example.newsapp.di.koinModuleApi
import com.example.newsapp.di.koinModuleRepository
import com.example.newsapp.di.koinModuleUseCase
import com.example.newsapp.di.koinModuleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsAppApplication)

            modules(
                koinModuleApi,
                koinModuleRepository,
                koinModuleUseCase,
                koinModuleViewModel
            )
        }
    }
}