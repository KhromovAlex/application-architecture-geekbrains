package com.example.applicationarchitecturegeekbrains.di

import com.example.applicationarchitecturegeekbrains.data.api.MovieApi
import com.example.applicationarchitecturegeekbrains.data.deserializer.MovieListDeserializer
import com.example.applicationarchitecturegeekbrains.domain.entity.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
            .baseUrl("https://api.themoviedb.org/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .addInterceptor {
                        val url = it.request().url.newBuilder()
                            .addQueryParameter("api_key", "fdd2c9ad989285a9045250f8404be872")
                            .build()

                        val request = it.request()
                            .newBuilder()
                            .url(url)
                            .build()

                        it.proceed(request)
                    }
                    .build()
            )
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .build()
            .create(MovieApi::class.java)

    private fun buildGson(): Gson =
        Gson()
            .newBuilder()
            .registerTypeAdapter(object : TypeToken<MutableList<Movie>>() {}.type, MovieListDeserializer())
            .create()

}
