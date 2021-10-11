package com.example.applicationarchitecturegeekbrains.presentation.movie

import dagger.assisted.AssistedFactory

@AssistedFactory
interface MovieDetailsPresenterFactory {

    fun create(id: Int): MovieDetailsPresenter

}
