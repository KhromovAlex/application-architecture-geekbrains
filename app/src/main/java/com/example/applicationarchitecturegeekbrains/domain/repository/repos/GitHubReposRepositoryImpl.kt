package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.RoomGithubRepositoriesCache
import io.reactivex.rxjava3.core.Observable

class GitHubReposRepositoryImpl(
    private val gitHubReposDataSource: GitHubReposDataSource,
    private val roomGithubRepositoriesCache: RoomGithubRepositoriesCache
) : GitHubReposRepository {

    override fun getRepositories(): Observable<List<GitHubRepos>> =
        Observable.merge(
            roomGithubRepositoriesCache.fetchRepositories().toObservable(),
            gitHubReposDataSource.fetchRepositories()
                .flatMap(roomGithubRepositoriesCache::retain).toObservable()
        )

}
