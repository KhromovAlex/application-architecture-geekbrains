package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApiFactory

object GitHubReposDataSourceFactory {

    fun create(): GitHubReposDataSource = GitHubReposDataSourceImpl(GitHubApiFactory.create())

}
