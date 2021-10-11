package com.example.applicationarchitecturegeekbrains.domain.repository

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.example.applicationarchitecturegeekbrains.data.datasource.movie.MovieDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.movie.RoomMovieCacheDataSource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val roomMovieCacheDataSource: RoomMovieCacheDataSource
) : MovieRepository {

    override fun getMovies(): Observable<List<Movie>> =
        Observable.merge(
            roomMovieCacheDataSource
                .getMovies(),
            movieDataSource
                .getMovies()
                .flatMap(roomMovieCacheDataSource::retain)
        )

    override fun getMovieById(id: Int): Observable<Movie> =
        roomMovieCacheDataSource
            .getMovieById(id)
            .onErrorResumeNext {
                movieDataSource.getMovieById(id)
            }

}
