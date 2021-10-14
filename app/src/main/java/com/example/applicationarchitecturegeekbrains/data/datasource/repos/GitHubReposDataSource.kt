package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Single

interface GitHubReposDataSource {

    fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>>

}
