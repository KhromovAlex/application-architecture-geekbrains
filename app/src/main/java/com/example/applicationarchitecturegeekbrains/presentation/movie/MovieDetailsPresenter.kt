package com.example.applicationarchitecturegeekbrains.presentation.movie

import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import com.example.applicationarchitecturegeekbrains.scheduler.Schedulers
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class MovieDetailsPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val schedulers: Schedulers,
    @Assisted private val id: Int
) : MvpPresenter<MovieDetailsView>() {

}
