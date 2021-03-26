package com.example.mylibapp.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylibapp.data.Film
import com.example.mylibapp.data.MovieApiImpl
import kotlinx.coroutines.launch

class FilmViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Film>>()
    val items: LiveData<List<Film>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = MovieApiImpl.getListOfFilms()
        }
    }
}