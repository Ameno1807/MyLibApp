package com.example.mylibapp.UI.anime.view

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
import com.example.mylibapp.UI.anime.viewModel.AnimeViewModelFactory
import com.example.mylibapp.UI.anime.viewModel.AnimeViewModelShiki
import com.example.mylibapp.UI.movie.viewModel.MovieListViewModelFactory
import com.example.mylibapp.UI.movie.viewModel.MoviesListViewModelImpl
import com.example.mylibapp.di.anime.AnimeRepositoryProvider
import com.example.mylibapp.di.movie.MovieRepositoryProvider
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie


class FragmentAnimeList : Fragment() {

    private val viewModel: AnimeViewModelShiki by viewModels {
        AnimeViewModelFactory((requireActivity() as AnimeRepositoryProvider).provideAnimeRepository())
    }

    private var listener: AnimeListItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is AnimeListItemClickListener) {
            listener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_anime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recycler_anime).apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            val adapter = FragmentAnimeAdapter { animeData ->
                listener?.onAnimeSelected(animeData)
            }

            this.adapter = adapter

            loadDataToAdapter(adapter)

        }


    }

    private fun loadDataToAdapter(adapter: FragmentAnimeAdapter) {
        viewModel.animeOutput.observe(viewLifecycleOwner, { animeList ->
            adapter.submitList(animeList)
        })
    }


    override fun onDetach() {
        listener = null

        super.onDetach()
    }

    interface AnimeListItemClickListener {
        fun onAnimeSelected(anime: Movie)
    }


}