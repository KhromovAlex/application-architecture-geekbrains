package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single

interface RoomGithubRepositoriesCache : GitHubReposDataSource {

    fun retain(repos: List<GitHubRepos>, url: String, userLogin: String): Single<List<GitHubRepos>>

}
