package com.example.applicationarchitecturegeekbrains.data

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
        val login = "KhromovAlex"
        val url = "https://github.com/KhromovAlex"

        gitHubReposDataSourceImpl.fetchRepositories(url = url, userLogin = login)

        Mockito.verify(gitHubApi, Mockito.times(1)).fetchRepositories(url = url)
    }
}
