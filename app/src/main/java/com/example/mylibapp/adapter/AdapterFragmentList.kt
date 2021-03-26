package com.example.mylibapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mylibapp.R
import com.example.mylibapp.data.Film

class AdapterFragmentList : RecyclerView.Adapter<FilmViewHolder>() {

    private val items = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_movie, null)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val imageUrl = items[position].imageUrl ?: ""
        holder.bind(imageUrl)
    }

    fun addItems(newItems: List<Film>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView = view.findViewById<ImageView>(R.id.movie_image)

    fun bind(imageUrl: String) {
        imageView.load(imageUrl)
    }
}