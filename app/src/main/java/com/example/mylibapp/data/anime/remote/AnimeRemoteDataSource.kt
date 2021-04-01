package com.example.mylibapp.data.anime.remote

import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie

interface AnimeRemoteDataSource {
    suspend fun loadAnime(): List<Anime>
}