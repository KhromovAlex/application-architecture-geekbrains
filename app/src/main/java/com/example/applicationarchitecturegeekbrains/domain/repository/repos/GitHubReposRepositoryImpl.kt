package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.RoomGithubRepositoriesCache
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GitHubReposRepositoryImpl @Inject constructor(
    private val gitHubReposDataSource: GitHubReposDataSource,
    private val roomGithubRepositoriesCache: RoomGithubRepositoriesCache
) : GitHubReposRepository {

    override fun getRepositories(url: String, userLogin: String): Observable<List<GitHubRepos>> =
        Observable.merge(
            roomGithubRepositoriesCache.fetchRepositories(url = url, userLogin = userLogin).toObservable(),
            gitHubReposDataSource.fetchRepositories(url = url, userLogin = userLogin)
                .flatMap{roomGithubRepositoriesCache.retain(repos = it, url = url, userLogin = userLogin)}.toObservable()
        )

}
