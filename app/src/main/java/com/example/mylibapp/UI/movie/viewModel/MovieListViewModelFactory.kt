package com.example.mylibapp.UI.movie.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mylibapp.repository.movie.MovieRepository

class MovieListViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MoviesListViewModelImpl(repository) as T
}