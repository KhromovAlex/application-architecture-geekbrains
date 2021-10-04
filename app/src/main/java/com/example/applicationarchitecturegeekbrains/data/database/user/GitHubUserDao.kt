package com.example.applicationarchitecturegeekbrains.data.database.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM github_user")
    fun fetchUsers(): Single<List<GitHubUser>>

    @Query("SELECT * FROM github_user WHERE login LIKE :login LIMIT 1")
    fun fetchUserByLogin(login: String): Single<GitHubUser>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GitHubUser>): Completable

    @Update(onConflict = REPLACE)
    fun retain(user: GitHubUser): Completable

}
