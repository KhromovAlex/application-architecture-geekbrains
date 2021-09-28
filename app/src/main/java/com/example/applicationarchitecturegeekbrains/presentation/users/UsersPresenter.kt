package com.example.applicationarchitecturegeekbrains.presentation.users

import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.presentation.user.UserScreen
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        userRepository
            .getUsers()
            .let(viewState::showUsers)

    }

    fun displayUser(user: GitHubUser) = router.navigateTo(UserScreen(user.login))

}
