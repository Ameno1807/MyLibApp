package com.example.mylibapp.data.movie.remote.retrofit.responce

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class MovieResponse (
    @SerialName("id") val id : Int,
    @SerialName("poster_path") val posterPath : String
)