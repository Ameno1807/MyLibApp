package com.example.mylibapp.data.anime.remote.retrofit.responce

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse (
    @SerialName("id") val id: Int,
    @SerialName("poster") val poster : String?
)