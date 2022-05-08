package com.example.newsapp.domain.usecase.getlistnews

import com.example.newsapp.data.api.entity.response.NewsResponse
import com.example.newsapp.data.api.utils.Result
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

internal class RealGetListNewsUseCaseTest {

    private val newsRepository = mock<NewsRepository>()
    private val result = mock<Result<NewsResponse>>()

    @Test
    fun `should return the same data as in repository`() = runBlocking {

        val testApiKey = "1111111111111111"
        val testDefaultCountry = "ru"

        Mockito.`when`(
            newsRepository.getListNews(
                testApiKey,
                testDefaultCountry
            )
        ).thenReturn(result)

        val useCase = RealGetListNewsUseCase(
            repository = newsRepository,
            testApiKey,
            testDefaultCountry
        )

        val actual = useCase.invoke()
        val expected = result

        Assertions.assertEquals(expected, actual)
    }
}