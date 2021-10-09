package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Observable

interface GitHubReposRepository {

    fun getRepositories(url: String, userLogin: String): Observable<List<GitHubRepos>>

}
