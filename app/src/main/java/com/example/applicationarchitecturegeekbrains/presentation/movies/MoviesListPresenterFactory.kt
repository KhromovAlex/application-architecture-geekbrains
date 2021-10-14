package com.example.applicationarchitecturegeekbrains.presentation.movies

import dagger.assisted.AssistedFactory

@AssistedFactory
interface MoviesListPresenterFactory {

    fun create(): MoviesListPresenter

}
