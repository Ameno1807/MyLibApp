package com.example.mylibapp.di.book

import com.example.mylibapp.repository.anime.AnimeRepository
import com.example.mylibapp.repository.book.BookRepository

interface BookRepositoryProvider {
    fun provideBookRepository(): BookRepository
}