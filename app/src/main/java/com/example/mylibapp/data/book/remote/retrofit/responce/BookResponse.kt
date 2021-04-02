package com.example.mylibapp.data.book.remote.retrofit.responce

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse (
    @SerialName("id") val id: Int,
    @SerialName("poster") val poster : String?,
    @SerialName("title") val title: String
        )
