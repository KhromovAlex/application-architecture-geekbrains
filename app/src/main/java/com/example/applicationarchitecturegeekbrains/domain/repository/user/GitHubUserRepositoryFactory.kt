package com.example.applicationarchitecturegeekbrains.domain.repository.user

import android.content.Context
import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSourceFactory
import com.example.applicationarchitecturegeekbrains.data.datasource.user.RoomGithubUsersCacheFactory

object GitHubUserRepositoryFactory {

    private var repository: GitHubUserRepository? = null

    private fun getInstance(context: Context): GitHubUserRepository {
        if (repository == null) {
            repository = GitHubUserRepositoryImpl(
                gitHubUserDataSource = GitHubUserDataSourceFactory.create(),
                roomGithubUsersCache = RoomGithubUsersCacheFactory.create(context)
            )
        }

        return repository!!
    }

    fun create(context: Context): GitHubUserRepository = getInstance(context)

}
