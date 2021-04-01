package com.example.mylibapp.data.anime.remote.retrofit

import com.example.mylibapp.data.anime.remote.retrofit.responce.UpComingAnime
import com.example.mylibapp.data.movie.remote.retrofit.responce.UpComingResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AnimeApiService {

    @GET("./getfilmlist")
    @Headers("Content-Type: application/json")
    suspend fun animeLoadUpcoming(): UpComingAnime
}