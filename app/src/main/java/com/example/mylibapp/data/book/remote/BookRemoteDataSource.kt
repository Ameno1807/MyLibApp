package com.example.mylibapp.data.book.remote

import com.example.mylibapp.model.Book


interface BookRemoteDataSource {
    suspend fun loadBook(): List<Book>
}