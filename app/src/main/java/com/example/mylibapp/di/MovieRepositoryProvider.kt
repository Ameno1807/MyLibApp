package com.example.mylibapp.di

import com.example.mylibapp.repository.MovieRepository

interface MovieRepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}