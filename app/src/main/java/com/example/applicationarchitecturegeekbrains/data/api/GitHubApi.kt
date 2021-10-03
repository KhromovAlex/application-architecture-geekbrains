package com.example.applicationarchitecturegeekbrains.data.api

import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET
    fun fetchRepositories(@Url url: String): Single<List<GitHubRepos>>

}
