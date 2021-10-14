package com.example.applicationarchitecturegeekbrains.di

import android.content.Context
import androidx.room.Room
import com.example.applicationarchitecturegeekbrains.data.database.RoomDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideRoomDataBase(context: Context): RoomDataBase =
        Room.inMemoryDatabaseBuilder(context, RoomDataBase::class.java)
            .fallbackToDestructiveMigration()
            .build()

}
