package com.example.applicationarchitecturegeekbrains.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "original_title")
    @SerializedName("original_title")
    val originalTitle: String,
    @ColumnInfo(name = "overview")
    @SerializedName("overview")
    val overview: String,
    @ColumnInfo(name = "poster_path")
    @SerializedName("poster_path")
    val posterPath: String,
    @ColumnInfo(name = "release_date")
    @SerializedName("release_date")
    val releaseDate: Date?
)
