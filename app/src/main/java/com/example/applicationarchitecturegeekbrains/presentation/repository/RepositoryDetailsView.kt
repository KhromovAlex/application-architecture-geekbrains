package com.example.applicationarchitecturegeekbrains.presentation.repository

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface RepositoryDetailsView : MvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showInfo(countForks: Int)

    @StateStrategyType(SingleStateStrategy::class)
    fun showError(throwable: Throwable)

}
