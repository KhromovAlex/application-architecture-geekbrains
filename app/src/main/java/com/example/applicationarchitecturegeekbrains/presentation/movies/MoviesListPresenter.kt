package com.example.applicationarchitecturegeekbrains.presentation.movies

import com.example.applicationarchitecturegeekbrains.domain.repository.MovieRepository
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class MoviesListPresenter @AssistedInject constructor(
    private val movieRepository: MovieRepository,
    private val router: Router,
) : MvpPresenter<MoviesListView>() {

}
