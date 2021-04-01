package com.example.mylibapp.UI.anime.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie

internal abstract class AnimeViewModel : ViewModel() {

    abstract val animeOutput: LiveData<List<Anime>>
}