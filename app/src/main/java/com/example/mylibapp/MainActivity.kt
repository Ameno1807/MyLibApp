package com.example.mylibapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mylibapp.movie.FragmentMovieList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            routeOnMovieList()
        }

    }




    fun routeOnMovieList() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, FragmentMovieList())
            commit()
        }

    }
}