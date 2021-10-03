package com.example.applicationarchitecturegeekbrains.domain.repository.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

}
