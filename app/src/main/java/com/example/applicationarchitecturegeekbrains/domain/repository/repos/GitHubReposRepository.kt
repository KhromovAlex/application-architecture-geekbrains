package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Single

interface GitHubReposRepository {

    fun getRepositories(url: String): Single<List<GitHubRepos>>

}
