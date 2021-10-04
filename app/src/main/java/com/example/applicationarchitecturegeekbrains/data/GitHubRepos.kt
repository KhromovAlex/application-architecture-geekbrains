package com.example.applicationarchitecturegeekbrains.data

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_repo")
data class GitHubRepos(
    @PrimaryKey
    @SerializedName("id")
    val idRepos: Int,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,
    @ColumnInfo(name = "forks")
    @SerializedName("forks")
    val forks: Int,
    @Embedded
    val owner: GitHubUser,
)
