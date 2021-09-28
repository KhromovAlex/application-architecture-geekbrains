package com.example.applicationarchitecturegeekbrains.data

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

object GitHubUserRepository {
    private val users: List<GitHubUser> = listOf(
        GitHubUser(id = 0, login = "login1"),
        GitHubUser(id = 1, login = "login2"),
        GitHubUser(id = 2, login = "login3"),
        GitHubUser(id = 3, login = "login4"),
        GitHubUser(id = 4, login = "login5")
    )

    fun getUsers(): Single<List<GitHubUser>> {
        return Single.just(users)
    }

    fun getUserById(id: Int): Maybe<GitHubUser> =
        users.firstOrNull { user -> user.id == id }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()


}
