package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomGithubRepositoriesCacheImpl @Inject constructor(
    private val roomDataBase: RoomDataBase
) : RoomGithubRepositoriesCache {
    override fun retain(repos: List<GitHubRepos>, url: String, userLogin: String): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .retain(repos)
            .andThen(fetchRepositories(url = url, userLogin = userLogin))

    override fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>> =
        roomDataBase
            .gitHubReposDao()
            .fetchRepos()
            .map { list -> list.filter { it.owner.login == userLogin } }
}
