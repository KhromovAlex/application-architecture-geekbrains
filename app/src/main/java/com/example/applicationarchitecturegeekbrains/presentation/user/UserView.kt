package com.example.applicationarchitecturegeekbrains.presentation.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UserView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLogin(login: String)

}
