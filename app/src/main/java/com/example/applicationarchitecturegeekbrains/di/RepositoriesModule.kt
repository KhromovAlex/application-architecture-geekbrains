package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSource
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSourceImpl
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.RoomGithubRepositoriesCache
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.RoomGithubRepositoriesCacheImpl
import com.example.applicationarchitecturegeekbrains.domain.repository.repos.GitHubReposRepository
import com.example.applicationarchitecturegeekbrains.domain.repository.repos.GitHubReposRepositoryImpl
import com.example.applicationarchitecturegeekbrains.presentation.repositories.RepositoriesFragment
import com.example.applicationarchitecturegeekbrains.presentation.repository.RepositoryDetailsFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface RepositoriesModule {

    @ContributesAndroidInjector
    fun bindRepositoriesFragment(): RepositoriesFragment

    @ContributesAndroidInjector
    fun bindRepositoryDetailsFragment(): RepositoryDetailsFragment

    @Binds
    fun bindGitHubReposRepository(gitHubReposRepositoryImpl: GitHubReposRepositoryImpl): GitHubReposRepository

    @Binds
    fun bindGitHubReposDataSource(gitHubReposDataSourceImpl: GitHubReposDataSourceImpl): GitHubReposDataSource

    @Binds
    fun bindRoomGithubRepositoriesCache(roomGithubRepositoriesCacheImpl: RoomGithubRepositoriesCacheImpl): RoomGithubRepositoriesCache

}
