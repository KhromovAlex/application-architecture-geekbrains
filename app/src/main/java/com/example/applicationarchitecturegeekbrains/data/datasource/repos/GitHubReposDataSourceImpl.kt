package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Single

class GitHubReposDataSourceImpl(
    private val gitHubApi: GitHubApi,
    private val url: String
) : GitHubReposDataSource {

    override fun fetchRepositories(): Single<List<GitHubRepos>> =
        gitHubApi.fetchRepositories(url)

}
