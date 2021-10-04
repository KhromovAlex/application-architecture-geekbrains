package com.example.applicationarchitecturegeekbrains.data.datasource.user

import android.content.Context
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBaseFactory

object RoomGithubUsersCacheFactory {

    fun create(context: Context): RoomGithubUsersCache =
        RoomGithubUsersCacheImpl(
            RoomDataBaseFactory.createInMemory(context)
        )

}
