package com.example.applicationarchitecturegeekbrains.presentation.model

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import java.util.*

data class MovieModel(
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: Date?
) {

    object Mapper {

        fun map(movie: Movie) =
            MovieModel(
                id = movie.id,
                originalTitle = movie.originalTitle,
                overview = movie.overview,
                posterPath = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}",
                releaseDate = movie.releaseDate,
            )

    }

}
