package com.example.applicationarchitecturegeekbrains.data.api

import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("/movie/popular")
    fun getMovies(): Single<List<Movie>>

    @GET("/movie/{movie_id}")
    fun getMovieById(@Path("movie_id") id: Int): Single<Movie>

}
