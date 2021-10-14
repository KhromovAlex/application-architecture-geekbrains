package com.example.applicationarchitecturegeekbrains.domain.repository

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import io.reactivex.rxjava3.core.Observable

interface MovieRepository {

    fun getMovies(): Observable<List<Movie>>

    fun getMovieById(id: Int): Observable<Movie>

}
