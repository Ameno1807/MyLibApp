package com.example.mylibapp.repository

import com.example.mylibapp.model.Movie

interface MovieRepository {
    suspend fun loadMovies(): List<Movie>
}