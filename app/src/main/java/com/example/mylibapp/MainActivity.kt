package com.example.mylibapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mylibapp.UI.adapter.MyPagerAdapter
import com.example.mylibapp.data.anime.remote.retrofit.AnimeRetrofitDataSource
import com.example.mylibapp.data.movie.remote.retrofit.RetrofitDataSource
import com.example.mylibapp.di.anime.AnimeNetworkModule
import com.example.mylibapp.di.anime.AnimeRepositoryProvider
import com.example.mylibapp.di.movie.MovieRepositoryProvider
import com.example.mylibapp.di.movie.NetworkModule
import com.example.mylibapp.repository.anime.AnimeRepository
import com.example.mylibapp.repository.anime.AnimeRepositoryShiki
import com.example.mylibapp.repository.movie.MovieRepository
import com.example.mylibapp.repository.movie.MovieRepositoryDB
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(),
    MovieRepositoryProvider,
    AnimeRepositoryProvider {

    private val networkModule = NetworkModule()
    private val remoteDataSource = RetrofitDataSource(networkModule.api)
    private val movieRepository = MovieRepositoryDB(remoteDataSource)

    private val animeNetworkModule = AnimeNetworkModule()
    private val animeRemoteDataSource = AnimeRetrofitDataSource(animeNetworkModule.api)
    private val animeRepository = AnimeRepositoryShiki(animeRemoteDataSource)

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

    override fun provideMovieRepository(): MovieRepository = movieRepository
    override fun provideAnimeRepository(): AnimeRepository = animeRepository


    /* fun routeOnMovieList() {
         supportFragmentManager.beginTransaction().apply {
             add(R.id.container, FragmentMovieList())
             commit()
         }*/
}
