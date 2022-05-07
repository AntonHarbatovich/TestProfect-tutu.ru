package com.example.newsapp.data.db

import android.content.Context
import androidx.room.Room

private const val DATABASE_NAME = "local-database"

fun createLocalDataBase(
    context: Context
): LocalDataBase = Room.databaseBuilder(
    context,
    LocalDataBase::class.java,
    DATABASE_NAME
).build()