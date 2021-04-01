package com.example.mylibapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mylibapp.UI.adapter.MyPagerAdapter
import com.example.mylibapp.data.remote.retrofit.RetrofitDataSource
import com.example.mylibapp.di.MovieRepositoryProvider
import com.example.mylibapp.di.NetworkModule
import com.example.mylibapp.repository.MovieRepository
import com.example.mylibapp.repository.MovieRepositoryDB
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(),
                     MovieRepositoryProvider {

    private val networkModule = NetworkModule()
    private val remoteDataSource = RetrofitDataSource(networkModule.api)
    private val movieRepository = MovieRepositoryDB(remoteDataSource)

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


    /* fun routeOnMovieList() {
         supportFragmentManager.beginTransaction().apply {
             add(R.id.container, FragmentMovieList())
             commit()
         }*/
}
