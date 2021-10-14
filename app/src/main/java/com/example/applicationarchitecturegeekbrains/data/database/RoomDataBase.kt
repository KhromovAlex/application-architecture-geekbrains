package com.example.applicationarchitecturegeekbrains.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.example.applicationarchitecturegeekbrains.data.database.movie.MovieDao

@Database(exportSchema = false, entities = [Movie::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
