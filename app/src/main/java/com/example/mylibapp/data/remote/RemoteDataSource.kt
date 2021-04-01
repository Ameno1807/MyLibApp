package com.example.mylibapp.data.remote

import com.example.mylibapp.model.Movie


interface RemoteDataSource {
    suspend fun loadMovies(): List<Movie>
}