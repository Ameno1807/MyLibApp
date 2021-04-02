package com.example.mylibapp.data.anime.remote.retrofit

import com.example.mylibapp.data.anime.remote.AnimeRemoteDataSource
import com.example.mylibapp.data.movie.remote.RemoteDataSource
import com.example.mylibapp.data.movie.remote.retrofit.MovieApiService
import com.example.mylibapp.data.movie.remote.retrofit.responce.ImageResponse
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie

class AnimeRetrofitDataSource(private val api: AnimeApiService): AnimeRemoteDataSource {

    override suspend fun loadAnime(): List<Anime> {

        return api.animeLoadUpcoming().results.map { anime ->
            Anime(
                id = anime.id,
                imageUrl = anime.poster,
                title = anime.title
            )
        }

    }

}