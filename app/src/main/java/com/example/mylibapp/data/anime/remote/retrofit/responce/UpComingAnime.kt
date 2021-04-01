package com.example.mylibapp.data.anime.remote.retrofit.responce

import com.example.mylibapp.data.movie.remote.retrofit.responce.MovieResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpComingAnime (
    @SerialName("items") val results: List<AnimeResponse>
)