package com.example.applicationarchitecturegeekbrains.presentation.user

import moxy.MvpPresenter
import java.lang.RuntimeException

class UserPresenter(
    private val login: String?
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (login != null) {
            viewState.showLogin(login)
        } else {
            viewState.showError(RuntimeException("Login undefined"))
        }
    }

}
