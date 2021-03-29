package com.example.mylibapp.data

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface MovieRepository {
     fun loadMovies(): List<Movie>
}

internal class JsonMovieRepository(private val context: Context) : MovieRepository{
    private val jsonFormat = Json { ignoreUnknownKeys = true }

    override fun loadMovies(): List<Movie> {

        val data = readAssetFileToString("data.json")

        return parseMovies(data)

    }

    private fun readAssetFileToString(fileName: String): String {
        val stream = context.assets.open(fileName)
        return stream.bufferedReader().readText()
    }

    private fun parseMovies(
        jsonString: String
    ): List<Movie>{
        val jsonMovies = jsonFormat.decodeFromString<List<Data>>(jsonString)

        return jsonMovies.map { jsonMovies ->
            Movie(
                imageUrl = jsonMovies.imageUrl,
                id = jsonMovies.id
            )
        }
    }

}