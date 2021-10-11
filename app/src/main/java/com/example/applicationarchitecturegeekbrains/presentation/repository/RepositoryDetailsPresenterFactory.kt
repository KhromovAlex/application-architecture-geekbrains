package com.example.applicationarchitecturegeekbrains.presentation.repository

import dagger.assisted.AssistedFactory

@AssistedFactory
interface RepositoryDetailsPresenterFactory {

    fun create(countForks: Int?): RepositoryDetailsPresenter

}
