package com.example.mylibapp.data.movie.remote.retrofit.responce

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpComingResponse (
    @SerialName("page") val page : Int,
    @SerialName("results") val results : List<MovieResponse>
    )