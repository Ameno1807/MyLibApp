package com.example.mylibapp.data.movie.remote.retrofit

import com.example.mylibapp.data.movie.remote.retrofit.responce.ConfigurationResponse
import com.example.mylibapp.data.movie.remote.retrofit.responce.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("configuration")
    suspend fun loadConfiguration(): ConfigurationResponse

    @GET("movie/upcoming")
    suspend fun loadUpcoming(
        @Query("page") page: Int
    ): UpComingResponse


}