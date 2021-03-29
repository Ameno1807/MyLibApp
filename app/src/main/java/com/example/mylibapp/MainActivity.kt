package com.example.mylibapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mylibapp.adapter.MyPagerAdapter
import com.example.mylibapp.data.JsonMovieRepository
import com.example.mylibapp.data.MovieRepository
import com.example.mylibapp.di.RepositoryProvider
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), RepositoryProvider {
    private val jsonMovieRepository = JsonMovieRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        val tabs = findViewById<TabLayout>(R.id.tabs)

        if(savedInstanceState == null) {
            viewPager.adapter = MyPagerAdapter(supportFragmentManager)
            tabs.setupWithViewPager(viewPager)
        }

    }

    override fun provideMovieRepository(): MovieRepository = jsonMovieRepository

    /* fun routeOnMovieList() {
         supportFragmentManager.beginTransaction().apply {
             add(R.id.container, FragmentMovieList())
             commit()
         }*/

}
