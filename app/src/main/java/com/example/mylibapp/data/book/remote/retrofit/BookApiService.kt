package com.example.mylibapp.data.book.remote.retrofit

import com.example.mylibapp.data.book.remote.retrofit.responce.UpComingBook
import retrofit2.http.GET
import retrofit2.http.Headers

interface BookApiService {

    @GET("./getBookList")
    @Headers("Content-Type: application/json")
    suspend fun bookLoadUpcoming(): UpComingBook
}