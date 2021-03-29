package com.example.mylibapp.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mylibapp.R
import com.example.mylibapp.adapter.FragmentMovieAdapter
import com.example.mylibapp.data.Movie
import com.example.mylibapp.di.RepositoryProvider
import kotlinx.coroutines.launch

class FragmentMovieList: Fragment() {

    private var listener: MoviesListItemClickListener? = null

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

            val adapter = FragmentMovieAdapter { Data ->
                listener?.onMovieSelected(Data)
            }

            this.adapter = adapter

            loadDataToAdapter(adapter)
        }


    }

    private fun loadDataToAdapter(adapter: FragmentMovieAdapter) {
        val repository = (requireActivity() as RepositoryProvider).provideMovieRepository()
        lifecycleScope.launch {
            val moviesData = repository.loadMovies()

            adapter.submitList(moviesData)
        }
    }

    override fun onDetach() {
        listener = null

        super.onDetach()
    }

    interface MoviesListItemClickListener {
        fun onMovieSelected(movie: Movie)
    }


}