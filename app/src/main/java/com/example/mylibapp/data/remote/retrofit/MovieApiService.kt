package com.example.mylibapp.data.remote.retrofit

import com.example.mylibapp.data.remote.retrofit.responce.ConfigurationResponse
import com.example.mylibapp.data.remote.retrofit.responce.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("configuration")
    suspend fun loadConfiguration(): ConfigurationResponse

    @GET("movie/upcoming")
    suspend fun loadUpcoming(
        @Query("page") page: Int
    ): UpComingResponse


}