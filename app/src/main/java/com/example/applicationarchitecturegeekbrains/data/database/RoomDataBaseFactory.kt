package com.example.applicationarchitecturegeekbrains.data.database

import android.content.Context
import androidx.room.Room

object RoomDataBaseFactory {

    fun createInMemory(context: Context): RoomDataBase =
        Room.inMemoryDatabaseBuilder(context, RoomDataBase::class.java)
            .fallbackToDestructiveMigration()
            .build()

}
