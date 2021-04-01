package com.example.mylibapp.di.anime

import com.example.mylibapp.repository.anime.AnimeRepository
import com.example.mylibapp.repository.movie.MovieRepository

interface AnimeRepositoryProvider {

    fun provideAnimeRepository(): AnimeRepository
}