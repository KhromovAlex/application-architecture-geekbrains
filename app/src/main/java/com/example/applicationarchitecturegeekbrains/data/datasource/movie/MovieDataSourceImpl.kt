package com.example.applicationarchitecturegeekbrains.data.datasource.movie

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.example.applicationarchitecturegeekbrains.data.api.MovieApi
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi,
) : MovieDataSource {
    override fun getMovies(): Observable<List<Movie>> =
        movieApi
            .getMovies()
            .toObservable()

    override fun getMovieById(id: Int): Observable<Movie> =
        movieApi
            .getMovieById(id)
            .toObservable()
}
