package com.example.applicationarchitecturegeekbrains.presentation.repositories

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.domain.repository.repos.GitHubReposRepository
import com.example.applicationarchitecturegeekbrains.presentation.repository.RepositoryDetailsScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class RepositoriesPresenter(
    private val gitHubReposRepository: GitHubReposRepository,
    private val router: Router,
    private val url: String,
    private val schedulers: com.example.applicationarchitecturegeekbrains.scheduler.Schedulers,
    private val userLogin: String
) : MvpPresenter<RepositoriesView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposable.add(
            gitHubReposRepository
                .getRepositories(url = url, userLogin = userLogin)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showRepositories,
                    viewState::showError,
                )
        )

    }

    fun displayRepositoryInfo(gitHubRepos: GitHubRepos) =
        router.navigateTo(RepositoryDetailsScreen(gitHubRepos.forks))

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}
