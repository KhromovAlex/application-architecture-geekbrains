package com.example.applicationarchitecturegeekbrains.presentation.users.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.applicationarchitecturegeekbrains.data.GitHubUser

class UsersDiffUtil(
    private val oldList: List<GitHubUser>,
    private val newList: List<GitHubUser>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].login == newList[newItemPosition].login
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
