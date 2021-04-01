package com.example.mylibapp.UI.anime.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mylibapp.R
import com.example.mylibapp.model.Anime
import com.example.mylibapp.model.Movie

class FragmentAnimeAdapter(private val onClickCard: (item: Movie) -> Unit) : androidx.recyclerview.widget.ListAdapter<Anime, FragmentAnimeAdapter.ViewHolder>(
    DiffCallback()
) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUrl: ImageView = itemView.findViewById(R.id.anime_image)

        fun bind(item: Anime) {

            imageUrl.load(item.imageUrl)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item_anime, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class DiffCallback : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            TODO("Not yet implemented")
        }
    }
}
