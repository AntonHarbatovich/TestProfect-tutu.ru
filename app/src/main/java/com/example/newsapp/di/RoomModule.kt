package com.example.newsapp.di

import com.example.newsapp.data.db.createLocalDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val koinRoomModule = module {

    single {
        createLocalDataBase(
            context = androidContext()
        )
    }
}