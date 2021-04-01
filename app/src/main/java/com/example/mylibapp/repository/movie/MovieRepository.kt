package com.example.mylibapp.repository.movie

import com.example.mylibapp.model.Movie

interface MovieRepository {
    suspend fun loadMovies(): List<Movie>
}