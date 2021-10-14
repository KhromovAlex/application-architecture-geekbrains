package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubReposDataSourceImpl @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubReposDataSource {

    override fun fetchRepositories(url: String, userLogin: String): Single<List<GitHubRepos>> =
        gitHubApi.fetchRepositories(url)

}
