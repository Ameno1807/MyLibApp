package com.example.mylibapp.data.book.remote.retrofit.responce

import com.example.mylibapp.data.anime.remote.retrofit.responce.AnimeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpComingBook (
    @SerialName("items") val results: List<BookResponse>
)