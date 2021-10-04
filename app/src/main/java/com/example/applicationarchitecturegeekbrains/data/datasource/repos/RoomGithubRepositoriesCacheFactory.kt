package com.example.applicationarchitecturegeekbrains.data.datasource.repos

import android.content.Context
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBaseFactory

object RoomGithubRepositoriesCacheFactory {

    fun create(context: Context, userLogin: String): RoomGithubRepositoriesCache =
        RoomGithubRepositoriesCacheImpl(
            RoomDataBaseFactory.createInMemory(context),
            userLogin
        )

}
