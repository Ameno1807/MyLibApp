package com.example.mylibapp.repository.anime

import com.example.mylibapp.data.anime.remote.retrofit.AnimeRetrofitDataSource
import com.example.mylibapp.data.movie.remote.retrofit.RetrofitDataSource
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie
import com.example.mylibapp.repository.movie.MovieRepository

class AnimeRepositoryShiki(
    private val animeRemoteDataResource: AnimeRetrofitDataSource
): AnimeRepository {


    override suspend fun loadAnime(): List<Anime> {
        return animeRemoteDataResource.loadAnime()
    }

}