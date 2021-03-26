package com.example.mylibapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MovieApi {

    @GET("/3/movie/550?api_key=f8706d2d323449854d66a634c1e7c156")
    suspend fun getListOfFilms(): Data
}

object MovieApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://api.themoviedb.org")
        .build()

    private val newYorkTimesService = retrofit.create(MovieApi::class.java)

    suspend fun getListOfFilms(): List<Film> {
        return withContext(Dispatchers.IO) {
            newYorkTimesService.getListOfFilms()
                .results
                .map {
                        result ->
                    Film(
                        result.imageUrl
                    )
                }
        }
    }
}