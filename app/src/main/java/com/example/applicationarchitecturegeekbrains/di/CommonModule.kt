package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CommonModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}
