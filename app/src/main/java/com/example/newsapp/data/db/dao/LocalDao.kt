package com.example.newsapp.data.db.dao

import androidx.room.*
import com.example.newsapp.data.db.entity.ArticleEntity

@Dao
interface LocalDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM article")
    suspend fun getAll(): List<ArticleEntity>

    @Query("DELETE FROM ARTICLE")
    suspend fun deleteAll()
}