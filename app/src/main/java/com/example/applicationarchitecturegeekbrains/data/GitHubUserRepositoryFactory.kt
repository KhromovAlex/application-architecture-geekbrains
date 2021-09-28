package com.example.applicationarchitecturegeekbrains.data

object GitHubUserRepositoryFactory {

    fun create(): GitHubUserRepository = GitHubUserRepositoryImpl()

}