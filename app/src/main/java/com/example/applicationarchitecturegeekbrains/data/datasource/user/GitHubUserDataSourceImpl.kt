package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

class GitHubUserDataSourceImpl(
    private val gitHubApi: GitHubApi,
) : GitHubUserDataSource {

    override fun getUsers(): Single<List<GitHubUser>> = gitHubApi.fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()

}
