package com.example.applicationarchitecturegeekbrains.domain.repository.user

import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSourceFactory

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl(
        gitHubUserDataSource = GitHubUserDataSourceFactory.create(),
    )

}
