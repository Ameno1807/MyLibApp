package com.example.mylibapp.UI.book.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mylibapp.repository.book.BookRepository


class BookListViewModelFactory(private val repository: BookRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = BookListViewModelAPI(repository) as T
}