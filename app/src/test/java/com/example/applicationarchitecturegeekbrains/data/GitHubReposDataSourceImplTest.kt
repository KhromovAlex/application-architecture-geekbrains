package com.example.applicationarchitecturegeekbrains.data

import com.example.applicationarchitecturegeekbrains.*
import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.datasource.repos.GitHubReposDataSourceImpl
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GitHubReposDataSourceImplTest {
    private lateinit var gitHubReposDataSourceImpl: GitHubReposDataSourceImpl

    @Mock
    private lateinit var gitHubApi: GitHubApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        gitHubReposDataSourceImpl = GitHubReposDataSourceImpl(gitHubApi = gitHubApi)
    }

    @Test
    fun fetchRepositoriesGitHub_Test() {
        gitHubReposDataSourceImpl.fetchRepositories(url = GITHUB_PROFILE_URL, userLogin = GITHUB_LOGIN)

        Mockito.verify(gitHubApi, Mockito.times(1)).fetchRepositories(url = GITHUB_PROFILE_URL)
    }
}
