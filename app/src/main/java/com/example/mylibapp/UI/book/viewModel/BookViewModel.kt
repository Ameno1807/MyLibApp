package com.example.mylibapp.UI.book.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mylibapp.model.Book


internal abstract class BookViewModel : ViewModel() {

    abstract val bookOutput: LiveData<List<Book>>
}