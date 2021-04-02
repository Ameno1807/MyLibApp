package com.example.mylibapp.data.book.remote.retrofit

import com.example.mylibapp.data.book.remote.BookRemoteDataSource
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Book

class BookRetrofitDataSource (private val api: BookApiService): BookRemoteDataSource {

    override suspend fun loadBook(): List<Book> {

        return api.bookLoadUpcoming().results.map { book ->
            Book(
                id = book.id,
                imageUrl = book.poster,
                title = book.title
            )
        }

    }

}