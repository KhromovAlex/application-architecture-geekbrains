package com.example.applicationarchitecturegeekbrains.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.data.database.repos.GitHubReposDao
import com.example.applicationarchitecturegeekbrains.data.database.user.GitHubUserDao

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubRepos::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

    abstract fun gitHubReposDao(): GitHubReposDao

}
