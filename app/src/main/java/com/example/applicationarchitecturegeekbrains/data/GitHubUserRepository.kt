package com.example.applicationarchitecturegeekbrains.data

interface GitHubUserRepository {

    fun getUsers(): List<GitHubUser>
}
