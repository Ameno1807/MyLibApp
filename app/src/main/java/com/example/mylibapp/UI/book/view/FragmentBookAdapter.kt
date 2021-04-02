package com.example.mylibapp.UI.book.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mylibapp.R
import com.example.mylibapp.UI.movie.view.FragmentMovieAdapter
import com.example.mylibapp.model.Book
import com.example.mylibapp.model.Movie

class FragmentBookAdapter(private val onClickCard: (item: Book) -> Unit) :
    androidx.recyclerview.widget.ListAdapter<Book, FragmentBookAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageUrl: ImageView = itemView.findViewById(R.id.book_image)
        private val title: TextView = itemView.findViewById(R.id.book_name_text)

        fun bind(item: Book) {

            imageUrl.load(item.imageUrl) {
                crossfade(true)
            }
            title.text = item.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_item_book, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class DiffCallback : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            TODO("Not yet implemented")
        }
    }
}