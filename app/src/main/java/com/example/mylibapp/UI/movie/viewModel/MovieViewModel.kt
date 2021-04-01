package com.example.mylibapp.UI.movie.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.mylibapp.model.Movie
import kotlinx.coroutines.launch

internal abstract class MovieViewModel : ViewModel() {

    abstract val moviesOutput: LiveData<List<Movie>>
}