package com.example.applicationarchitecturegeekbrains.presentation.user

import moxy.MvpPresenter

class UserPresenter(
    private val login: String?
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (login != null) {
            viewState.showLogin(login)
        }
    }

}
