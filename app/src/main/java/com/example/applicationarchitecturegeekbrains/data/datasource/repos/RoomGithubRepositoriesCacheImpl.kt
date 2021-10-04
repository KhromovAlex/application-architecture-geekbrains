package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBase
import io.reactivex.rxjava3.core.Single

class RoomGithubRepositoriesCacheImpl(
    private val roomDataBase: RoomDataBase,
    private val userLogin: String
) : RoomGithubRepositoriesCache {
    override fun retain(repos: List<GitHubRepos>): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .retain(repos)
            .andThen(fetchRepositories())

    override fun fetchRepositories(): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .fetchRepos()
            .map { list -> list.filter { it.owner.login == userLogin } }
}
