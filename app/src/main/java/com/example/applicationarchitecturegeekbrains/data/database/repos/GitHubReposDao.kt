package com.example.applicationarchitecturegeekbrains.data.database.repos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubReposDao {
    @Query("SELECT * FROM github_repo")
    fun fetchRepos(): Single<List<GitHubRepos>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(users: List<GitHubRepos>): Completable
}
