package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserView : MvpView {


    @StateStrategyType(SingleStateStrategy::class)
    fun showLogin(user: GitHubUser)

    @StateStrategyType(SingleStateStrategy::class)
    fun showError(throwable: Throwable)

    @StateStrategyType(SingleStateStrategy::class)
    fun undefinedLogin()

}
