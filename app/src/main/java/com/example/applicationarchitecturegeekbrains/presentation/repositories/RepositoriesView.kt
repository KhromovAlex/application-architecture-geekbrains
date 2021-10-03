package com.example.applicationarchitecturegeekbrains.presentation.repositories

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RepositoriesView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showRepositories(list: List<GitHubRepos>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showError(throwable: Throwable)

}
