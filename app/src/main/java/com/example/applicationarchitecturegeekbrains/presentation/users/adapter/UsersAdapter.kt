package com.example.applicationarchitecturegeekbrains.presentation.users.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubUser

class UsersAdapter(private val delegate: UserClickListener) :
    RecyclerView.Adapter<UserViewHolder>() {
    private val list: MutableList<GitHubUser> = mutableListOf()

    interface UserClickListener {
        fun onClickUser(user: GitHubUser)
    }

    fun submitList(users: List<GitHubUser>) {
        val callback =
            UsersDiffUtil(
                list,
                users
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.user_list_item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickUser(it.tag as GitHubUser)
        }
        return UserViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}
