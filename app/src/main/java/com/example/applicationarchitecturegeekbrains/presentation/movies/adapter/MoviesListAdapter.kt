package com.example.applicationarchitecturegeekbrains.presentation.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel

class MoviesListAdapter(private val delegate: MovieClickListener) :
    RecyclerView.Adapter<MoviesListViewHolder>() {
    private val list: MutableList<MovieModel> = mutableListOf()

    interface MovieClickListener {
        fun onClickMovie(movie: MovieModel)
    }

    fun submitList(moviesList: List<MovieModel>) {
        val callback =
            MoviesListDiffUtil(
                list,
                moviesList
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(moviesList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.movies_list_item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickMovie(it.tag as MovieModel)
        }
        return MoviesListViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}
