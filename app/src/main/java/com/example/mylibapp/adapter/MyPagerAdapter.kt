package com.example.mylibapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mylibapp.anime.FragmentAnimeList
import com.example.mylibapp.book.FragmentBookList
import com.example.mylibapp.movie.FragmentMovieList

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
