package com.example.applicationarchitecturegeekbrains.data

import com.example.applicationarchitecturegeekbrains.data.api.GitHubApi
import com.example.applicationarchitecturegeekbrains.data.datasource.user.GitHubUserDataSourceImpl
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GitHubUserDataSourceImplTest {
    private lateinit var gitHubUserDataSourceImpl: GitHubUserDataSourceImpl

    @Mock
    private lateinit var gitHubApi: GitHubApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        gitHubUserDataSourceImpl = GitHubUserDataSourceImpl(gitHubApi = gitHubApi)
    }

    @Test
    fun fetchUsersGitHub_Test() {
        gitHubUserDataSourceImpl.getUsers()

        Mockito.verify(gitHubApi, Mockito.times(1)).fetchUsers()
    }

    @Test
    fun fetchUserByLoginGitHub_Test() {
        val login = "KhromovAlex"

        Mockito.`when`(gitHubApi.getUserByLogin(login)).thenReturn(Single.never())
        gitHubUserDataSourceImpl.getUserByLogin(login)

        Mockito.verify(gitHubApi, Mockito.times(1)).getUserByLogin(login)
    }
}
