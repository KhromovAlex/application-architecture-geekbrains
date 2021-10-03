package com.example.applicationarchitecturegeekbrains.presentation.repositories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos

class RepositoriesAdapter(private val delegate: RepoClickListener) :
    RecyclerView.Adapter<RepositoriesViewHolder>() {
    private val list: MutableList<GitHubRepos> = mutableListOf()

    interface RepoClickListener {
        fun onClickRepo(repo: GitHubRepos)
    }

    fun submitList(users: List<GitHubRepos>) {
        val callback =
            RepositoriesDiffUtil(
                list,
                users
            )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.repo_list_item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickRepo(it.tag as GitHubRepos)
        }
        return RepositoriesViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.tag = list[position]
    }

    override fun getItemCount(): Int = list.size

}
