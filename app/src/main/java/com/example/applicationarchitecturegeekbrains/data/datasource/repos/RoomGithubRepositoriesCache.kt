package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Single

interface RoomGithubRepositoriesCache : GitHubReposDataSource {

    fun retain(repos: List<GitHubRepos>): Single<List<GitHubRepos>>

}
