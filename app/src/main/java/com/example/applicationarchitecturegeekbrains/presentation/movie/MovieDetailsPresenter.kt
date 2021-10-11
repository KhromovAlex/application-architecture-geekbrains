package com.example.applicationarchitecturegeekbrains.presentation.movie

import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class MovieDetailsPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    @Assisted private val id: Int
) : MvpPresenter<MovieDetailsView>() {

}
