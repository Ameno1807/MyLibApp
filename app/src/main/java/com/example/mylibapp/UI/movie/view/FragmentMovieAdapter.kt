package com.example.mylibapp.UI.movie.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mylibapp.R
import com.example.mylibapp.model.Movie

class FragmentMovieAdapter(private val onClickCard: (item: Movie) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Movie, FragmentMovieAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUrl: ImageView = itemView.findViewById(R.id.movie_image)

        fun bind(item: Movie) {

            imageUrl.load(item.imageUrl) {
                crossfade(true)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            TODO("Not yet implemented")
        }
    }
}









