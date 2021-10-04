package com.example.applicationarchitecturegeekbrains.domain.repository.repos

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Observable

interface GitHubReposRepository {

    fun getRepositories(): Observable<List<GitHubRepos>>

}
