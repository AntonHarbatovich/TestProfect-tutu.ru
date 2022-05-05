package com.example.newsapp

import android.app.Application
import com.example.newsapp.api.koinModuleApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NewsAppApplication)

            modules(
                koinModuleApi,
            )
        }
    }
}