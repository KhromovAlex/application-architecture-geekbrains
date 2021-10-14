package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.data.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class MovieApiModule {

    @Reusable
    @Provides
    fun provideGitHubApi(): MovieApi =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)

}
