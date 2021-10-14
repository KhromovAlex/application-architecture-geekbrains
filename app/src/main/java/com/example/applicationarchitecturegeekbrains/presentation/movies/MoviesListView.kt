package com.example.applicationarchitecturegeekbrains.presentation.movies

import com.example.applicationarchitecturegeekbrains.presentation.model.MovieModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MoviesListView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMovies(list: List<MovieModel>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)
}
