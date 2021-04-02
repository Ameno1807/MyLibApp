package com.example.mylibapp.UI.book.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibapp.R
import com.example.mylibapp.UI.book.viewModel.BookListViewModelAPI
import com.example.mylibapp.UI.book.viewModel.BookListViewModelFactory
import com.example.mylibapp.UI.movie.view.FragmentMovieAdapter
import com.example.mylibapp.UI.movie.viewModel.MovieListViewModelFactory
import com.example.mylibapp.UI.movie.viewModel.MoviesListViewModelImpl
import com.example.mylibapp.di.book.BookRepositoryProvider
import com.example.mylibapp.di.movie.MovieRepositoryProvider
import com.example.mylibapp.model.Book
import com.example.mylibapp.model.Movie

class FragmentBookList : Fragment() {

    private val viewModel: BookListViewModelAPI by viewModels {
        BookListViewModelFactory((requireActivity() as BookRepositoryProvider).provideBookRepository())
    }

    private var listener: BookListItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is BookListItemClickListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_book).apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            val adapter = FragmentBookAdapter { bookData ->
                listener?.onBookSelected(bookData)
            }

            this.adapter = adapter

            loadDataToAdapter(adapter)

        }


    }

    private fun loadDataToAdapter(adapter: FragmentBookAdapter) {
        viewModel.bookOutput.observe(viewLifecycleOwner, { bookList ->
            adapter.submitList(bookList)
        })
    }


    override fun onDetach() {
        listener = null

        super.onDetach()
    }

    interface BookListItemClickListener {
        fun onBookSelected(book: Book)
    }




}