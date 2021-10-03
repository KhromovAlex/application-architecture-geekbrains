package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSourceFactory

object GitHubReposRepositoryFactory {

    fun create(): GitHubReposRepository = GitHubReposRepositoryImpl(
        gitHubReposDataSource = GitHubReposDataSourceFactory.create(),
    )

}
