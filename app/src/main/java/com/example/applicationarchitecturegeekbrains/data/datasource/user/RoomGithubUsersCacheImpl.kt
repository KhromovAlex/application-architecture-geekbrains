package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBase
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RoomGithubUsersCacheImpl @Inject constructor(
    private val roomDataBase: RoomDataBase
) : RoomGithubUsersCache {

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        roomDataBase
            .gitHubUserDao()
            .retain(users)
            .andThen(getUsers())

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        roomDataBase
            .gitHubUserDao()
            .retain(user)
            .andThen(getUserByLogin(user.login))
            .toSingle()

    override fun getUsers(): Single<List<GitHubUser>> =
        roomDataBase
            .gitHubUserDao()
            .fetchUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        roomDataBase
            .gitHubUserDao()
            .fetchUserByLogin(userId)
            .toMaybe()

}
