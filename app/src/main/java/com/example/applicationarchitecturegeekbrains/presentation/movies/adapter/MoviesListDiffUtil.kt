package com.example.applicationarchitecturegeekbrains.presentation.movies.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel

class MoviesListDiffUtil(
    private val oldList: List<MovieModel>,
    private val newList: List<MovieModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
