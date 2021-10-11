package com.example.applicationarchitecturegeekbrains.presentation.repositories

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface RepositoriesPresenterFactory {

    fun create(@Assisted("url") url: String, @Assisted("userLogin") userLogin: String): RepositoriesPresenter

}
