package com.example.mylibapp.repository.book

import com.example.mylibapp.data.book.remote.retrofit.BookRetrofitDataSource
import com.example.mylibapp.model.Book



class BookRepositoryAPI(
    private val bookRemoteDataResource: BookRetrofitDataSource
): BookRepository {


    override suspend fun loadBook(): List<Book> {
        return bookRemoteDataResource.loadBook()
    }

}