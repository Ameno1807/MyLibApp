package com.example.mylibapp.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.mylibapp.R
import com.example.mylibapp.adapter.AdapterFragmentList
import kotlinx.android.synthetic.main.fragment_movie_list.*

class FragmentMovieList: Fragment() {

    private val itemAdapter = AdapterFragmentList()

    private val filmViewModel by viewModels<FilmViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.apply {
            adapter = itemAdapter
            layoutManager = GridLayoutManager(this.context, 2)
        }

        filmViewModel.items.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            itemAdapter.    addItems(it)
        })

    }

}