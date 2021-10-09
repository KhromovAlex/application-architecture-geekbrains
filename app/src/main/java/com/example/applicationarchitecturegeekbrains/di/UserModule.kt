package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSourceImpl
import com.example.applicationarchitecturegeekbrains.data.datasource.user.RoomGithubUsersCache
import com.example.applicationarchitecturegeekbrains.data.datasource.user.RoomGithubUsersCacheImpl
import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepository
import com.example.applicationarchitecturegeekbrains.domain.repository.user.GitHubUserRepositoryImpl
import com.example.applicationarchitecturegeekbrains.presentation.user.UserFragment
import com.example.applicationarchitecturegeekbrains.presentation.users.UsersFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface UserModule {

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @Binds
    fun bindGitHubUserRepository(gitHubUserRepositoryImpl: GitHubUserRepositoryImpl): GitHubUserRepository

    @Binds
    fun bindGitHubUserDataSource(gitHubUserDataSourceImpl: GitHubUserDataSourceImpl): GitHubUserDataSource

    @Binds
    fun bindRoomGithubUsersCache(roomGithubUsersCacheImpl: RoomGithubUsersCacheImpl): RoomGithubUsersCache

}
