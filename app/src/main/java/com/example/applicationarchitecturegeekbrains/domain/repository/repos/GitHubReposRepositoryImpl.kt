package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSource
import io.reactivex.rxjava3.core.Single

class GitHubReposRepositoryImpl(
    private val gitHubReposDataSource: GitHubReposDataSource
) : GitHubReposRepository {

    override fun getRepositories(url: String): Single<List<GitHubRepos>> =
        gitHubReposDataSource
            .fetchRepositories(url)

}
