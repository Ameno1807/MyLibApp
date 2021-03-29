package com.example.mylibapp.di

import com.example.mylibapp.data.MovieRepository

internal interface RepositoryProvider {
    fun provideMovieRepository(): MovieRepository
}