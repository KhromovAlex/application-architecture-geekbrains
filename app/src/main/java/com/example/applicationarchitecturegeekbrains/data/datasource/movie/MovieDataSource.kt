package com.example.applicationarchitecturegeekbrains.data.datasource.movie

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable

interface MovieDataSource {

    fun getMovies(): Observable<List<Movie>>

    fun getMovieById(id: Int): Observable<Movie>

}
