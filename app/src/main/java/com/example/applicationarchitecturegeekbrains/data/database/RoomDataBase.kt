package com.example.applicationarchitecturegeekbrains.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.applicationarchitecturegeekbrains.data.database.converters.Converters
import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.example.applicationarchitecturegeekbrains.data.database.movie.MovieDao

@Database(exportSchema = false, entities = [Movie::class], version = 1)
@TypeConverters(Converters::class)
abstract class RoomDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}
