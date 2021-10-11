package com.example.applicationarchitecturegeekbrains.data.datasource.movie

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable

interface RoomMovieCacheDataSource : MovieDataSource {

    fun retain(movies: List<Movie>): Observable<List<Movie>>

    fun retain(movie: Movie): Observable<Movie>

}
