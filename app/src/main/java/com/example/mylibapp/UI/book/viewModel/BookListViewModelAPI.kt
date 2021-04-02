package com.example.mylibapp.UI.book.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mylibapp.model.Book
import com.example.mylibapp.repository.book.BookRepository
import kotlinx.coroutines.launch

internal class BookListViewModelAPI(private val repository: BookRepository) : BookViewModel() {

    override val bookOutput = MutableLiveData<List<Book>>()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            bookOutput.postValue(repository.loadBook())
        }
    }
}