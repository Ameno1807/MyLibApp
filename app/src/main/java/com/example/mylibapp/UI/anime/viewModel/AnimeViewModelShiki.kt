package com.example.mylibapp.UI.anime.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mylibapp.UI.movie.viewModel.MovieViewModel
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie
import com.example.mylibapp.repository.anime.AnimeRepository
import com.example.mylibapp.repository.movie.MovieRepository
import kotlinx.coroutines.launch

internal class AnimeViewModelShiki(private val repository: AnimeRepository) : AnimeViewModel() {

    override val animeOutput = MutableLiveData<List<Anime>>()

    init {
        loadAnime()
    }

    private fun loadAnime() {
        viewModelScope.launch {
            animeOutput.postValue(repository.loadAnime())
        }
    }
}
