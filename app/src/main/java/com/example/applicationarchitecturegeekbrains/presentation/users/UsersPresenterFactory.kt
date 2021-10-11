package com.example.applicationarchitecturegeekbrains.presentation.users

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UsersPresenterFactory {

    fun create(): UsersPresenter

}
