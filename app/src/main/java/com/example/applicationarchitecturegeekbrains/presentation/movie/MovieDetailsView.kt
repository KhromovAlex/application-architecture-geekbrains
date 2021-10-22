package com.example.applicationarchitecturegeekbrains.presentation.movie

import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface MovieDetailsView : MvpView {

    @SingleState
    fun showMovie(movie: MovieModel)

    @SingleState
    fun showError(throwable: Throwable)

}
