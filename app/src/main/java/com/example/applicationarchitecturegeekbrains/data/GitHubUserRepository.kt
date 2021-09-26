package com.example.applicationarchitecturegeekbrains.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

object GitHubUserRepository {
    private val observableUsers: Observable<List<GitHubUser>> = Observable.just(
        listOf(
            GitHubUser(id = 0, login = "login1"),
            GitHubUser(id = 1, login = "login2"),
            GitHubUser(id = 2, login = "login3"),
            GitHubUser(id = 3, login = "login4"),
            GitHubUser(id = 4, login = "login5")
        )
    )

    fun getUsers(): Observable<List<GitHubUser>> {
        return observableUsers.subscribeOn(Schedulers.io())
    }

    fun getUserById(id: Int): Observable<GitHubUser> {
        return observableUsers
            .flatMap { Observable.fromIterable(it) }
            .filter { it.id == id }
            .subscribeOn(Schedulers.io())
    }
}
