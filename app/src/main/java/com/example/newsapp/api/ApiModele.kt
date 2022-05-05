package com.example.newsapp.api

import com.example.newsapp.data.api.http.createHttpClient
import com.example.newsapp.data.api.http.createNewsApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val HTTP_CLIENT_BASE = "api.client.mobile"

val koinModuleApi = module {

    single(named(HTTP_CLIENT_BASE)) {
        createHttpClient()
    }

    single {
        createNewsApi(
            httpClient = get(named(HTTP_CLIENT_BASE)),
            hostUrl = "https://newsapi.org/v2/"
        )
    }
}
