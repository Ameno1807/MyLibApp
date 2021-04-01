package com.example.mylibapp.UI.movie.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibapp.R
import com.example.mylibapp.UI.movie.viewModel.MovieListViewModelFactory
import com.example.mylibapp.UI.movie.viewModel.MovieViewModel
import com.example.mylibapp.UI.movie.viewModel.MoviesListViewModelImpl
import com.example.mylibapp.di.MovieRepositoryProvider
import com.example.mylibapp.model.Movie

class FragmentMovieList: Fragment() {

    private val viewModel: MoviesListViewModelImpl by viewModels {
        MovieListViewModelFactory((requireActivity() as MovieRepositoryProvider).provideMovieRepository())
    }

    private var listener: MoviesListItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is MoviesListItemClickListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_movie).apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            val adapter = FragmentMovieAdapter { movieData ->
                listener?.onMovieSelected(movieData)
            }

            this.adapter = adapter

            loadDataToAdapter(adapter)

        }


    }

    private fun loadDataToAdapter(adapter: FragmentMovieAdapter) {
        viewModel.moviesOutput.observe(viewLifecycleOwner, { movieList ->
            adapter.submitList(movieList)
        })
    }


    override fun onDetach() {
        listener = null

        super.onDetach()
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected(movie: Movie)
    }


}