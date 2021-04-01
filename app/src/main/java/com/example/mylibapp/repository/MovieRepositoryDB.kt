package com.example.mylibapp.repository

import com.example.mylibapp.data.remote.retrofit.RetrofitDataSource
import com.example.mylibapp.model.Movie

class MovieRepositoryDB(
    private val remoteDataResource: RetrofitDataSource
): MovieRepository {

    override suspend fun loadMovies(): List<Movie> {
        return remoteDataResource.loadMovies()
    }

}