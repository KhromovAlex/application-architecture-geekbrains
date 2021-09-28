package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import java.lang.RuntimeException

class UserPresenter(
    private val userId: Int?,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<UserView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        if (userId != null) {
            disposable.add(
                userRepository.getUserById(id = userId)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        viewState::showLogin,
                        viewState::showError,
                        viewState::undefinedLogin,
                    )
            )
        } else {
            viewState.showError(RuntimeException("Login undefined"))
        }

    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
