package com.example.applicationarchitecturegeekbrains.presentation.user

import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.presentation.repositories.RepositoriesScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: Router,
    private val schedulers: com.example.applicationarchitecturegeekbrains.scheduler.Schedulers,
) : MvpPresenter<UserView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        disposables.add(
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
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
