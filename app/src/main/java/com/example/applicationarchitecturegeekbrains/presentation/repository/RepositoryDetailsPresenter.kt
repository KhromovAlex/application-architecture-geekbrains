package com.example.applicationarchitecturegeekbrains.presentation.repository

import moxy.MvpPresenter

class RepositoryDetailsPresenter(
    private val countForks: Int?,
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
