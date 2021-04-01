package com.example.mylibapp.UI.anime.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mylibapp.UI.movie.viewModel.MoviesListViewModelImpl
import com.example.mylibapp.repository.anime.AnimeRepository
import com.example.mylibapp.repository.movie.MovieRepository

class AnimeViewModelFactory(private val repository: AnimeRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = AnimeViewModelShiki(repository) as T
}