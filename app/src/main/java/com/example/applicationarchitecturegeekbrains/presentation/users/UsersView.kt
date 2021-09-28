package com.example.applicationarchitecturegeekbrains.presentation.users

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface UsersView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showUsers(list: List<GitHubUser>)

}
