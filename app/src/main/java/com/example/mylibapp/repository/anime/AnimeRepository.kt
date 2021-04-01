package com.example.mylibapp.repository.anime

import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie

interface AnimeRepository {
    suspend fun loadAnime(): List<Anime>
}