package com.example.mylibapp.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Data(
    val id: Int,
    @SerialName("poster_path") val imageUrl: String?
)
