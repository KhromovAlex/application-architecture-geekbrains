package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.presentation.repositories.RepositoriesScreen
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter @AssistedInject constructor(
    @Assisted private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: Router,
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    viewState::showUser,
                    viewState::showError
                )
        )
    }

    fun displayRepositories() =
        disposables.add(
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                    { router.navigateTo(RepositoriesScreen(it.repos_url, it.login)) },
                    viewState::showError
                )
        )

    override fun onDestroy() {
        disposables.clear()
    }

}
