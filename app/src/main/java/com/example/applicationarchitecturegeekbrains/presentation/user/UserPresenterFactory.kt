package com.example.applicationarchitecturegeekbrains.presentation.user

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UserPresenterFactory {

    fun create(userLogin: String): UserPresenter

}
