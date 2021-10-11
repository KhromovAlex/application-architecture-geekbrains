package com.example.applicationarchitecturegeekbrains.presentation.repository

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class RepositoryDetailsPresenter @AssistedInject constructor(
    @Assisted private val countForks: Int?,
) : MvpPresenter<RepositoryDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (countForks != null) {
            viewState.showInfo(countForks)
        } else {
            viewState.showError(RuntimeException("Count is null"))
        }

    }

}
