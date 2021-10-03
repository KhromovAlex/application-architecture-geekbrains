package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi,
) : GitHubUserDataSource {

    override fun fetchUsers(): Single<List<GitHubUser>> = gitHubApi.fetchUsers()

}
