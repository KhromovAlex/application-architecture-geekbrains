package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApiFactory

object GitHubReposDataSourceFactory {

    fun create(url: String): GitHubReposDataSource = GitHubReposDataSourceImpl(GitHubApiFactory.create(), url)

}
