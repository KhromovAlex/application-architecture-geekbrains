package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.data.datasource.movie.MovieDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.movie.MovieDataSourceImpl
import com.example.applicationarchitecturegeekbrains.data.datasource.movie.RoomMovieCacheDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.movie.RoomMovieCacheDataSourceImpl
import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepositoryImpl
import com.example.applicationarchitecturegeekbrains.presentation.movie.MovieDetailsFragment
import com.example.applicationarchitecturegeekbrains.presentation.movies.MoviesListFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MovieModule {

    @ContributesAndroidInjector
    fun bindMovieDetailsFragment(): MovieDetailsFragment

    @ContributesAndroidInjector
    fun bindMoviesListFragment(): MoviesListFragment

    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    fun bindMovieDataSource(movieDataSourceImpl: MovieDataSourceImpl): MovieDataSource

    @Binds
    fun bindRoomMovieCacheDataSource(roomMovieCacheDataSourceImpl: RoomMovieCacheDataSourceImpl): RoomMovieCacheDataSource

}
