package com.example.mylibapp.di.movie

import com.example.mylibapp.repository.movie.MovieRepository

interface MovieRepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}