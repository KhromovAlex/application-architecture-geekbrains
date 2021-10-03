package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GitHubUserDataSource {

    fun fetchUsers(): Single<List<GitHubUser>>

}
