package com.example.applicationarchitecturegeekbrains.presentation.repositories.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var repoText: TextView = itemView.findViewById(R.id.repoText)

    fun bind(user: GitHubRepos) {
        repoText.text = user.name
    }

}
