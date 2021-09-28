package com.example.applicationarchitecturegeekbrains.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserView : MvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showLogin(login: String)

    @StateStrategyType(SingleStateStrategy::class)
    fun showError(error: Throwable)

}
