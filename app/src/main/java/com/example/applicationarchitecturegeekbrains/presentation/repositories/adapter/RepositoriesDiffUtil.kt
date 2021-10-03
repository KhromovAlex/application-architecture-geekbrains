package com.example.applicationarchitecturegeekbrains.presentation.repositories.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos

class RepositoriesDiffUtil(
    private val oldList: List<GitHubRepos>,
    private val newList: List<GitHubRepos>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
