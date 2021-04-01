package com.example.mylibapp.UI.movie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mylibapp.model.Movie
import com.example.mylibapp.repository.movie.MovieRepository
import kotlinx.coroutines.launch

internal class MoviesListViewModelImpl(private val repository: MovieRepository) : MovieViewModel() {

    override val moviesOutput = MutableLiveData<List<Movie>>()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            moviesOutput.postValue(repository.loadMovies())
        }
    }
}
