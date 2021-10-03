package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApiFactory

object GitHubUserDataSourceFactory {

    fun create(): GitHubUserDataSource = GitHubUserDataSourceImpl(GitHubApiFactory.create())

}
