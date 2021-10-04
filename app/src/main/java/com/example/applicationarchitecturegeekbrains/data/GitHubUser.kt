package com.example.applicationarchitecturegeekbrains.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "github_user")
data class GitHubUser(
    @PrimaryKey
    @SerializedName("id")
    val idUser: Int,
    @ColumnInfo(name = "login")
    @SerializedName("login")
    val login: String,
    @ColumnInfo(name = "repos_url")
    @SerializedName("repos_url")
    val repos_url: String,
)
