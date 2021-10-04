package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import android.content.Context
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSourceFactory
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.RoomGithubRepositoriesCacheFactory

object GitHubReposRepositoryFactory {

    private var repository: GitHubReposRepository? = null

    private fun getInstance(context: Context, url: String, userLogin: String): GitHubReposRepository {
        println("repository == null")
        println(repository == null)
        if (repository == null) {
            repository = GitHubReposRepositoryImpl(
                gitHubReposDataSource = GitHubReposDataSourceFactory.create(url = url),
                roomGithubRepositoriesCache = RoomGithubRepositoriesCacheFactory.create(context, userLogin = userLogin)
            )
        }
        return repository!!
    }

    fun create(context: Context, url: String, userLogin: String): GitHubReposRepository = getInstance(context = context, url = url, userLogin = userLogin)

}
