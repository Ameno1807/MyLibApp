package com.example.mylibapp.UI.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mylibapp.UI.anime.view.FragmentAnimeList
import com.example.mylibapp.UI.book.FragmentBookList
import com.example.mylibapp.UI.movie.view.FragmentMovieList

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FragmentMovieList()
            }
            1 -> FragmentAnimeList()
            else -> {
                return FragmentBookList()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Фильмы"
            1 -> "Аниме"
            else -> {
                return "Книги"
            }
        }
    }
}
