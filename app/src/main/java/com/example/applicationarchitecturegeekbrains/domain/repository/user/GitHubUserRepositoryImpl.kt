package com.example.applicationarchitecturegeekbrains.domain.repository.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSource
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl(
    private val gitHubUserDataSource: GitHubUserDataSource
) : GitHubUserRepository {

    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubUserDataSource.fetchUsers()

}
