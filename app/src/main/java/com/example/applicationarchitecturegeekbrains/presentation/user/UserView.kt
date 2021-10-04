package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface UserView : MvpView {

    @SingleState
    fun showUser(user: GitHubUser)

    @SingleState
    fun showError(error: Throwable)

}
