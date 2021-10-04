package com.example.applicationarchitecturegeekbrains.presentation.users

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.presentation.repositories.RepositoriesScreen
import com.example.applicationarchitecturegeekbrains.presentation.user.UserScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UsersView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            userRepository
                .getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUsers,
                    viewState::showError,
                )
        )

    }

    fun displayUser(user: GitHubUser) = router.navigateTo(UserScreen(user.login))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
