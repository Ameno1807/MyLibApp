package com.example.mylibapp.repository.book

import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Book

interface BookRepository {
    suspend fun loadBook(): List<Book>
}