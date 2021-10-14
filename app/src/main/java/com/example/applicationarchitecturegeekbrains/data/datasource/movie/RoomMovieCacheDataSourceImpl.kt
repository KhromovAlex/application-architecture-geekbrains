package com.example.applicationarchitecturegeekbrains.data.datasource.movie

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBase
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RoomMovieCacheDataSourceImpl @Inject constructor(
    private val roomDataBase: RoomDataBase
) : RoomMovieCacheDataSource {
    override fun retain(movies: List<Movie>): Observable<List<Movie>> =
        roomDataBase
            .movieDao()
            .retain(movies)
            .andThen(getMovies())

    override fun retain(movie: Movie): Observable<Movie> =
        roomDataBase
            .movieDao()
            .retain(movie)
            .andThen(getMovieById(movie.id))

    override fun getMovies(): Observable<List<Movie>> =
        roomDataBase
            .movieDao()
            .fetchMovies()

    override fun getMovieById(id: Int): Observable<Movie> =
        roomDataBase
            .movieDao()
            .fetchMovieById(id)
}
