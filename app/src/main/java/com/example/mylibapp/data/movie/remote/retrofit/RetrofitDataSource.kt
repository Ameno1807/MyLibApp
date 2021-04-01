package com.example.mylibapp.data.movie.remote.retrofit

import com.example.mylibapp.data.movie.remote.RemoteDataSource
import com.example.mylibapp.model.Movie
import com.example.mylibapp.data.movie.remote.retrofit.responce.ImageResponse


class RetrofitDataSource(private val api: MovieApiService): RemoteDataSource {

    companion object {
        const val DEFAULT_SIZE = "original"
    }

    private var imageResponse: ImageResponse? = null
    private var baseUrl: String? = null
    private var posterSize: String? = null
    private var backdropSize: String? = null
    private var profileSize: String? = null

   override suspend fun loadMovies(): List<Movie> {
        loadConfiguration()

        return api.loadUpcoming(page = 1).results.map { movie ->
            Movie(
                id = movie.id,
                imageUrl = formingUrl(baseUrl, posterSize, movie.posterPath)
                )
        }



    }

    private suspend fun loadConfiguration() {
        if (imageResponse == null) {
            imageResponse = api.loadConfiguration().images
            baseUrl = imageResponse?.secureBaseUrl
            // TODO придумать более изящный вариант
            posterSize = imageResponse?.posterSizes?.find { it == "w500" }
            // TODO придумать более изящный вариант
            backdropSize = imageResponse?.backdropSizes?.find { it == "w780" }
            // TODO придумать более изящный вариант
            profileSize = imageResponse?.profileSizes?.find { it == "w185" }
        }
    }

    private fun formingUrl(url: String?, size: String?, path: String?) : String? {
        return if (url == null || path == null) {
            null
        } else {
            url.plus(size.takeUnless { it.isNullOrEmpty() }?: DEFAULT_SIZE)
                .plus(path)
        }
    }
}