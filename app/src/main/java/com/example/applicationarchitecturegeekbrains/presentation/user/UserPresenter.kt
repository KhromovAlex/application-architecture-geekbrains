package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUserRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UserPresenter(
    private val userId: Int?,
    private val userRepository: GitHubUserRepository,
) : MvpPresenter<UserView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (userId == null) return

        disposable.add(
            userRepository.getUserById(userId)
                .subscribe(
                    viewState::showLogin,
                    viewState::showError,
                )
        )

    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}
