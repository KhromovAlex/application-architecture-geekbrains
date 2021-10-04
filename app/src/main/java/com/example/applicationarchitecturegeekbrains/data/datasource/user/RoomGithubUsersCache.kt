package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single

interface RoomGithubUsersCache : GitHubUserDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>

    fun retain(user: GitHubUser): Single<GitHubUser>

}
